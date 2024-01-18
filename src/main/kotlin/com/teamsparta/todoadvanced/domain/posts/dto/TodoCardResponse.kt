package com.teamsparta.todoadvanced.domain.posts.dto

data class TodoCardResponse(
    val id: Long,
    val title: String,
    val content: String,
    val authorName: String,
)

