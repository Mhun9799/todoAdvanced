package com.teamsparta.todoadvanced.domain.todocards.service

import com.teamsparta.todoadvanced.domain.exception.ModelNotFoundException
import com.teamsparta.todoadvanced.domain.todocards.dto.CreateTodoCardRequest
import com.teamsparta.todoadvanced.domain.todocards.dto.TodoCardResponse
import com.teamsparta.todoadvanced.domain.todocards.dto.UpdateTodoCardRequest
import com.teamsparta.todoadvanced.domain.todocards.model.TodoCard
import com.teamsparta.todoadvanced.domain.todocards.repository.TodoCardRepository
import com.teamsparta.todoadvanced.domain.users.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.format.DateTimeFormatter

@Service
class TodoCardServiceImpl(
    private val todoCardRepository: TodoCardRepository,
    private val userRepository: UserRepository
) : TodoCardService {
    @Transactional
    override fun createTodoCard(userId:Long, request: CreateTodoCardRequest): TodoCardResponse {
        val user = userRepository.findByIdOrNull(userId)
            ?: throw ModelNotFoundException("todoCard", userId)
        return todoCardRepository.save(
            TodoCard(
                title = request.title,
                content = request.title,
                user = user,
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
    val date = createdDate!!.format(DateTimeFormatter.ofPattern("yyyyMMdd"))
    return TodoCardResponse(
        id = id!!,
        title = title,
        content = content,
        date = date,
        user = user
    )
}