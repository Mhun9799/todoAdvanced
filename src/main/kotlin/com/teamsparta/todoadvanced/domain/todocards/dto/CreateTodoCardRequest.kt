package com.teamsparta.todoadvanced.domain.todocards.dto

import com.teamsparta.todoadvanced.domain.users.model.User

data class CreateTodoCardRequest(
    val title: String,
    val content: String,
)