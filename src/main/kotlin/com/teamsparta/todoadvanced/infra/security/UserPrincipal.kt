package com.teamsparta.todoadvanced.infra.security

import com.teamsparta.todoadvanced.domain.users.model.User


data class UserPrincipal(
    val id: Long,
    val username: String,
) {
    fun toResponse(): User {
        return User(
            id = id,
            username = username,
            password = "",
        )
    }
}