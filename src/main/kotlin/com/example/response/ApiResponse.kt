package com.example.response

import org.springframework.http.HttpStatus

data class ApiResponse<T> (
    val message: String,
    val data : T,
    val httpStatus : HttpStatus
)