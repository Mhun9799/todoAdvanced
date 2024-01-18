package com.teamsparta.todoadvanced.domain.todocards.controller

import com.teamsparta.todoadvanced.domain.todocards.dto.CreateTodoCardRequest
import com.teamsparta.todoadvanced.domain.todocards.dto.TodoCardResponse
import com.teamsparta.todoadvanced.domain.todocards.dto.UpdateTodoCardRequest
import com.teamsparta.todoadvanced.domain.todocards.service.TodoCardService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RequestMapping("/todo-cards")
@RestController
class TodoCardController(private val todoCardService: TodoCardService) {
    @PostMapping
    fun createTodoCard(@RequestBody todoCardRequest: CreateTodoCardRequest): ResponseEntity<TodoCardResponse> {

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(todoCardService.createTodoCard(todoCardRequest))
    }

    @GetMapping("/{todoCardId}")
    fun findTodoCard(@PathVariable todoCardId: Long): ResponseEntity<TodoCardResponse> {
        val todoCard = todoCardService.findTodoCard(todoCardId)
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoCard)
    }

    @GetMapping
    fun findAllTodoCard(): ResponseEntity<List<TodoCardResponse>> {
        val todoCards = todoCardService.findTodoCardList()
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoCards)
    }

    @PostMapping("/{todoCardId}")
    fun updateTodoCard(
        @PathVariable todoCardId: Long,
        todoCardRequest: UpdateTodoCardRequest
    ): ResponseEntity<TodoCardResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoCardService.updateTodoCard(todoCardId, todoCardRequest))
    }

    @PatchMapping("/{todoCardId}/complete")
    fun completeTodoCard(@PathVariable todoCardId: Long): ResponseEntity<Unit> {
        todoCardService.completeTodoCard(todoCardId)
        return ResponseEntity
            .status(HttpStatus.OK)
            .build()
    }

    @DeleteMapping("/{todoCardId}")
    fun deleteTodoCard(@PathVariable todoCardId: Long): ResponseEntity<Unit> {
        todoCardService.deleteTodoCard(todoCardId)
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }
}