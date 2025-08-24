package com.example.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.example.entity.SessionDO
import org.apache.ibatis.annotations.Mapper

@Mapper
interface SessionMapper : BaseMapper<SessionDO> {
}