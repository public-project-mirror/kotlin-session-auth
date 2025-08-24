package com.example.interceptor

import com.example.exception.BaseHttpException
import com.example.response.ApiResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandlerControllerAdvice {
    @ExceptionHandler(BaseHttpException::class)
    fun handleBaseHttpException(e : BaseHttpException) : ResponseEntity<ApiResponse<String>> {
        val apiResponse = ApiResponse (
            message = e.message,
            data = "",
            httpStatus = e.httpStatus,
        )
        return ResponseEntity.status(e.httpStatus).body(apiResponse)
    }

    @ExceptionHandler(Throwable::class)
    fun handleThrowable(t : Throwable) : ResponseEntity<ApiResponse<String>> {
        val apiResponse = ApiResponse(
            message = t.message ?: "An unexpected error occurred",
            data = "",
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
        )
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse)
    }
}