package com.teamsparta.todoadvanced.domain.users.controller

import com.teamsparta.todoadvanced.domain.users.dto.CreateUserRequest
import com.teamsparta.todoadvanced.domain.users.dto.UserResponse
import com.teamsparta.todoadvanced.domain.users.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("users")
@RestController
class UserController(private val userService: UserService) {

    @PostMapping
    fun createUser(@RequestBody userRequest: CreateUserRequest): ResponseEntity<UserResponse> {
        val creatUserResponse = userService.createUser(userRequest)
        return ResponseEntity(creatUserResponse, HttpStatus.CREATED)
    }

    /*@PostMapping("/sign-in")
    fun signIn(){
        TODO()
    }*/


}