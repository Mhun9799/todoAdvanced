package com.teamsparta.todoadvanced.domain.todocards.dto

data class TodoCardResponse(
    val id: Long,
    val title: String,
    val content: String,
    val date: String,
    val authorName: String,
)

