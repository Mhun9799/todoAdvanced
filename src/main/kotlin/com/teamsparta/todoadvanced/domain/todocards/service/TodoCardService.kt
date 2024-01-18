package com.teamsparta.todoadvanced.domain.todocards.service

import com.teamsparta.todoadvanced.domain.todocards.dto.CreateTodoCardRequest
import com.teamsparta.todoadvanced.domain.todocards.dto.TodoCardResponse
import com.teamsparta.todoadvanced.domain.todocards.dto.UpdateTodoCardRequest

interface TodoCardService {

    fun createTodoCard(request: CreateTodoCardRequest): TodoCardResponse

    fun findTodoCardList():List<TodoCardResponse>

    fun findTodoCard(todoId: Long): TodoCardResponse

    fun updateTodoCard(todoId: Long, request: UpdateTodoCardRequest): TodoCardResponse

    fun deleteTodoCard(todoId: Long)

    fun completeTodoCard(todoId: Long)

}