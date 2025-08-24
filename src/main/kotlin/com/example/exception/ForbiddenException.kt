package com.example.exception

import org.springframework.http.HttpStatus

class ForbiddenException(message: String) : BaseHttpException(
    message = message,
    httpStatus = HttpStatus.FORBIDDEN,
)