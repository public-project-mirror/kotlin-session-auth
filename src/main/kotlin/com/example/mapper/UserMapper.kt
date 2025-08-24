package com.example.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.example.entity.UserDO
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper : BaseMapper<UserDO> {
}