package com.teamsparta.todoadvanced.domain.users.dto

data class CreateUserRequest(
    val username: String,
    val password: String,
)
