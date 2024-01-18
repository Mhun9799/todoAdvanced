package com.teamsparta.todoadvanced.domain.todocards.repository

import com.teamsparta.todoadvanced.domain.todocards.model.TodoCard
import org.springframework.data.jpa.repository.JpaRepository


interface TodoCardRepository : JpaRepository<TodoCard, Long> {
}