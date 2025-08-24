package com.example.exception

import org.springframework.http.HttpStatus

abstract class BaseHttpException (
    override val message: String,
    val httpStatus : HttpStatus,
) : RuntimeException(message)