package com.teamsparta.todoadvanced.domain.posts.dto

data class UpdateTodoCardRequest(
    val id: Long,
    val title: String,
    val content: String,
)