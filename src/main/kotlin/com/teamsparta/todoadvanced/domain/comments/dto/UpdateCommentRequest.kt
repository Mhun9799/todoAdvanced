package com.teamsparta.todoadvanced.domain.comments.dto

data class UpdateCommentRequest(
    val content: String,
    val authorName: String,
    val password: String,
)