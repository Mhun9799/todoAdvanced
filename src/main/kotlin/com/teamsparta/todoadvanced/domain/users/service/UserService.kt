package com.teamsparta.todoadvanced.domain.users.service

import com.teamsparta.todoadvanced.domain.users.dto.LoginRequest
import com.teamsparta.todoadvanced.domain.users.dto.CreateUserRequest
import com.teamsparta.todoadvanced.domain.users.dto.LoginResponse
import com.teamsparta.todoadvanced.domain.users.dto.UserResponse

interface UserService {
    fun createUser(request: CreateUserRequest): UserResponse
    fun login(request: LoginRequest): LoginResponse
}