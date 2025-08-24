package com.example.controller

import com.example.request.LoginRequest
import com.example.response.ApiResponse
import com.example.service.AuthService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
class AuthController (
    val authService: AuthService
) {
    @RequestMapping("/authenticate", method = [RequestMethod.GET])
    fun authenticate(@RequestParam sessionId: String) : ApiResponse<String> {
        return ApiResponse(
            message = "Authentication successful",
            data = authService.authenticate(sessionId),
            httpStatus = HttpStatus.OK
        )
    }

    @RequestMapping("/login", method = [RequestMethod.POST])
    fun login(@RequestBody loginRequest: LoginRequest) : ApiResponse<String> {
        return ApiResponse(
            message = "Login successful",
            data = authService.login(
                username = loginRequest.username,
                password = loginRequest.password),
            httpStatus = HttpStatus.OK
        )
    }
}