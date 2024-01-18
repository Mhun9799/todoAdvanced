package com.teamsparta.todoadvanced.domain.todocards.service

import com.teamsparta.todoadvanced.domain.exception.ModelNotFoundException
import com.teamsparta.todoadvanced.domain.todocards.dto.CreateTodoCardRequest
import com.teamsparta.todoadvanced.domain.todocards.dto.TodoCardResponse
import com.teamsparta.todoadvanced.domain.todocards.dto.UpdateTodoCardRequest
import com.teamsparta.todoadvanced.domain.todocards.model.TodoCard
import com.teamsparta.todoadvanced.domain.todocards.repository.TodoCardRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TodoCardServiceImpl(
    private val todoCardRepository: TodoCardRepository
) : TodoCardService {
    @Transactional
    override fun createTodoCard(request: CreateTodoCardRequest): TodoCardResponse {
        return todoCardRepository.save(
            TodoCard(
                title = request.title,
                content = request.title,
                authorName = request.authorName,
            )
        ).toResponse()
    }

    @Transactional
    override fun findTodoCardList(): List<TodoCardResponse> {
        val todoCardList = todoCardRepository.findAll().map { it.toResponse() }
        return todoCardList
    }

    @Transactional
    override fun findTodoCard(todoId: Long): TodoCardResponse {
        val todoCard = todoCardRepository.findByIdOrNull(todoId)
            ?: throw ModelNotFoundException("todoCard", todoId)
        return todoCard.toResponse()
    }

    @Transactional
    override fun updateTodoCard(todoId: Long, request: UpdateTodoCardRequest): TodoCardResponse {
        val todoCard = todoCardRepository.findByIdOrNull(todoId)
            ?: throw ModelNotFoundException("todoCard", todoId)
        todoCard.title = request.title
        todoCard.content = request.content
        return todoCardRepository.save(todoCard).toResponse()
    }

    @Transactional
    override fun deleteTodoCard(todoId: Long) {
        val todoCard = todoCardRepository.findByIdOrNull(todoId)
            ?: throw ModelNotFoundException("todoCard", todoId)

        todoCardRepository.delete(todoCard)
    }

    @Transactional
    override fun completeTodoCard(todoId: Long) {
        val todoCard = todoCardRepository.findByIdOrNull(todoId)
            ?: throw ModelNotFoundException("todoCard", todoId)

        todoCard.complete()
    }
}


fun TodoCard.toResponse(): TodoCardResponse {
    return TodoCardResponse(
        id = id!!,
        title = title,
        content = content,
        authorName = authorName,
    )
}