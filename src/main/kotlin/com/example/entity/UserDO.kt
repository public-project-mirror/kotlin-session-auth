package com.example.entity

import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName

@TableName("users")
data class UserDO(
    @TableId
    val userId: String,

    @TableField
    val username: String,

    @TableField
    val password: String,


)
