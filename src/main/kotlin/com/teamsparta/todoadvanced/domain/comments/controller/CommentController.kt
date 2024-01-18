package com.teamsparta.todoadvanced.domain.comments.controller

import com.teamsparta.todoadvanced.domain.comments.dto.CommentResponse
import com.teamsparta.todoadvanced.domain.comments.dto.CreateCommentRequest
import com.teamsparta.todoadvanced.domain.comments.service.CommentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/todo-cards/{todoCardId}/comments")
@RestController
class CommentController(
    private val commentService: CommentService,
) {

    @PostMapping
    fun createComment(
        @PathVariable todoCardId: Long,
        @RequestBody commentRequest: CreateCommentRequest
    ): ResponseEntity<CommentResponse>{
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(commentService.createComment(todoCardId,commentRequest))
    }
    @PostMapping("/{commentId}")
    fun updateComment(){
        TODO()
    }
    @DeleteMapping("/{commnetId}")
    fun deleteComment(){
        TODO()
    }
}