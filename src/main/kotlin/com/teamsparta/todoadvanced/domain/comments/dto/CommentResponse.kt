package com.teamsparta.todoadvanced.domain.comments.dto

data class CommentResponse(
    var id: Long,
    val content: String,
    //val user: User
    val authorName : String,


)