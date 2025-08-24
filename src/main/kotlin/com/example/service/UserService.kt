package com.example.service

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.example.entity.UserDO
import com.example.exception.AlreadyExistsException
import com.example.mapper.UserMapper
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserService (
    val userMapper: UserMapper,
) {
    fun register(username : String, password : String) : String {
        val queryWrapper = QueryWrapper<UserDO>().eq("username", username)
        val exists = userMapper.selectCount(queryWrapper) > 0

        if (exists) {
            throw AlreadyExistsException("User already exists")
        } else {
            val userId = UUID.randomUUID().toString()
            userMapper.insert(UserDO(
                userId = userId,
                username = username,
                password = password)
            )
            return userId
        }
    }
}