package com.example.exception

import org.springframework.http.HttpStatus

class NotFoundException(message: String) : BaseHttpException(
    message = message,
    httpStatus = HttpStatus.NOT_FOUND,
)