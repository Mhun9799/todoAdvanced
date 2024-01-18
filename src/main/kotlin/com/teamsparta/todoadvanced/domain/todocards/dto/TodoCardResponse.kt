package com.teamsparta.todoadvanced.domain.todocards.dto

import com.teamsparta.todoadvanced.domain.users.model.User

data class TodoCardResponse(
    val id: Long,
    val title: String,
    val content: String,
    val date: String,

)

