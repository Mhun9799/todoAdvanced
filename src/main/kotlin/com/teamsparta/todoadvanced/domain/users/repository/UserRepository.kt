package com.teamsparta.todoadvanced.domain.users.repository

import com.teamsparta.todoadvanced.domain.todocards.model.TodoCard
import com.teamsparta.todoadvanced.domain.users.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {

}