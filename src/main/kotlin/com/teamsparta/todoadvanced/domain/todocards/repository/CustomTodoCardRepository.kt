package com.teamsparta.todoadvanced.domain.todocards.repository

import com.teamsparta.todoadvanced.domain.todocards.model.TodoCard

interface CustomTodoCardRepository {
    fun findAllByOrderByCreatedAtDesc(): List<TodoCard>
    fun findAllByOrderByCreatedAtAsc(): List<TodoCard>
    fun findAllByAuthorId(authorId: Long): List<TodoCard>
}