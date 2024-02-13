package com.teamsparta.todoadvanced.domain.todocards.repository

import com.querydsl.core.BooleanBuilder
import com.teamsparta.todoadvanced.domain.todocards.model.TodoCard
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface CustomTodoCardRepository {
    fun findAllByOrderByCreatedAtDesc(): List<TodoCard>
    fun findAllByOrderByCreatedAtAsc(): List<TodoCard>
    fun findAllByAuthorId(authorId: Long): List<TodoCard>

    fun findByPageableAndStatus(pageable: Pageable,title: String?): Page<TodoCard>

}