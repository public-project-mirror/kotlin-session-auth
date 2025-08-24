package com.example.service

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.example.entity.SessionDO
import com.example.entity.UserDO
import com.example.exception.ForbiddenException
import com.example.exception.NotFoundException
import com.example.exception.UnauthorizedException
import com.example.mapper.SessionMapper
import com.example.mapper.UserMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class AuthService (
    val userMapper: UserMapper,
    val sessionMapper: SessionMapper
) {
    @Transactional
    fun authenticate(sessionId : String) : String {
        val userId = sessionMapper.selectById(sessionId)?.userId
            ?:throw UnauthorizedException("UnauthorizedException")
        return userMapper.selectById(userId)?.username ?: ""
    }

    @Transactional
fun login(username: String, password: String): String {
    // 使用普通的QueryWrapper
    val queryWrapper = QueryWrapper<UserDO>().eq("username", username)
    val userDO = userMapper.selectOne(queryWrapper)
        ?: throw NotFoundException("User not found")

    if (userDO.password != password) {
        throw ForbiddenException("Username does not match password")
    }

    // 查询session
    val sessionQueryWrapper = QueryWrapper<SessionDO>().eq("user_id", userDO.userId)
    val sessionDO = sessionMapper.selectOne(sessionQueryWrapper)

    return if (sessionDO != null) {
        sessionDO.sessionId
    } else {
        val sessionId = UUID.randomUUID().toString()
        sessionMapper.insert(SessionDO(sessionId, userDO.userId))
        sessionId
    }
}
}