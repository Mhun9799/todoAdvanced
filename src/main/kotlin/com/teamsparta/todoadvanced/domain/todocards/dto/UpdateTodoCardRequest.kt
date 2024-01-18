package com.teamsparta.todoadvanced.domain.todocards.dto

data class UpdateTodoCardRequest(
    val title: String,
    val content: String,
)