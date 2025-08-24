package com.example.exception

import org.springframework.http.HttpStatus

class UnauthorizedException(message: String) : BaseHttpException(
    message = message,
    httpStatus = HttpStatus.UNAUTHORIZED,
)