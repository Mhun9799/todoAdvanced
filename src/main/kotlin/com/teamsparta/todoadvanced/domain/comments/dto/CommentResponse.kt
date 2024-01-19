package com.teamsparta.todoadvanced.domain.comments.dto

import com.teamsparta.todoadvanced.domain.users.model.User

data class CommentResponse(
    var id: Long,
    val content: String,
    val user: User

)