package com.example.controller

import com.example.request.RegisterRequest
import com.example.response.ApiResponse
import com.example.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
@CrossOrigin
class UserController(
    val userService: UserService
) {
    @RequestMapping("/register", method = [RequestMethod.POST])
    fun register(@RequestBody registerRequest: RegisterRequest) : ApiResponse<String> {
        return ApiResponse(
            message = "register successful",
            data = userService.register(
                username = registerRequest.username,
                password = registerRequest.password),
            httpStatus = HttpStatus.OK
        )
    }
}