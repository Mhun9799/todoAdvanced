package com.teamsparta.todoadvanced.domain.todocards.dto

data class UpdateTodoCardRequest(
    val id: Long,
    val title: String,
    val content: String,
)