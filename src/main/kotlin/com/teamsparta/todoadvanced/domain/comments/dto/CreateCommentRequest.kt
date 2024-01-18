package com.teamsparta.todoadvanced.domain.comments.dto

data class CreateCommentRequest(
    val content: String,
    val authorName: String,
    val password: String,
)