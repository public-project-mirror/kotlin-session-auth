package com.example.entity

import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName

@TableName("session")
data class SessionDO (
    @TableId
    val sessionId : String,

    @TableField
    val userId : String,
)