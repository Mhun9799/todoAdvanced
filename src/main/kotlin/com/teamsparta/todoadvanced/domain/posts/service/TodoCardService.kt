package com.teamsparta.todoadvanced.domain.posts.service

import com.teamsparta.todoadvanced.domain.posts.dto.CreateTodoCardRequest
import com.teamsparta.todoadvanced.domain.posts.dto.TodoCardResponse
import com.teamsparta.todoadvanced.domain.posts.dto.UpdateTodoCardRequest
import com.teamsparta.todoadvanced.domain.posts.model.TodoCard

interface TodoCardService {

    fun createTodoCard(request: CreateTodoCardRequest): TodoCardResponse

    fun findTodoCardList():List<TodoCardResponse>

    fun findTodoCard(todoId: Long): TodoCardResponse

    fun updateTodoCard(todoId: Long, request: UpdateTodoCardRequest): TodoCardResponse

    fun deleteTodoCard(todoId: Long)

    fun completeTodoCard(todoId: Long)

}