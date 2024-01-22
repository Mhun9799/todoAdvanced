package com.teamsparta.todoadvanced.domain.users.model

import jakarta.persistence.*

@Entity
@Table(name = "app_user")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(name = "user_name", nullable = false)
    val username: String,
    @Column(name = "password", nullable = false)
    val password: String,

)