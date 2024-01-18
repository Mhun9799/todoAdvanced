package com.teamsparta.todoadvanced.domain.posts.dto

data class CreateTodoCardRequest(
    val title: String,
    val content: String,
    val authorName: String,
)