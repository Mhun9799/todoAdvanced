package com.teamsparta.todoadvanced.domain.users.dto

data class SignInUserRequest(
    val username: String,
    val password: String,
)