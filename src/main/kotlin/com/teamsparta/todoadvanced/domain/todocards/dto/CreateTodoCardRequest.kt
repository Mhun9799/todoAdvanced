package com.teamsparta.todoadvanced.domain.todocards.dto

data class CreateTodoCardRequest(
    val title: String,
    val content: String,
    val authorName: String,
)