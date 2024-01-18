package com.teamsparta.todoadvanced.domain.posts.repository

import com.teamsparta.todoadvanced.domain.posts.model.TodoCard
import org.springframework.data.jpa.repository.JpaRepository


interface TodoCardRepository : JpaRepository<TodoCard, Long> {
}