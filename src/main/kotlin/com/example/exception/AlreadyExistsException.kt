package com.example.exception

import org.springframework.http.HttpStatus

class AlreadyExistsException(message : String) : BaseHttpException (
    message = message,
    httpStatus = HttpStatus.CONFLICT
)