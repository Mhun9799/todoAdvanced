package com.teamsparta.todoadvanced.domain.comments.controller

import com.teamsparta.todoadvanced.domain.comments.dto.CommentResponse
import com.teamsparta.todoadvanced.domain.comments.dto.CreateCommentRequest
import com.teamsparta.todoadvanced.domain.comments.dto.UpdateCommentRequest
import com.teamsparta.todoadvanced.domain.comments.service.CommentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.annotation.AuthenticationPrincipal



@RequestMapping("/todo-cards/{todoCardId}/comments")
@RestController
class CommentController(
    private val commentService: CommentService,
) {

    @PostMapping
    fun createComment(
        @AuthenticationPrincipal user: User,
        @PathVariable todoCardId: Long,
        @RequestBody commentRequest: CreateCommentRequest
    ): ResponseEntity<CommentResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(commentService.createComment(user.username.toLong(),todoCardId, commentRequest))
    }

    @PostMapping("/{commentId}")
    fun updateComment(
        @PathVariable todoCardId: Long,
        @PathVariable commentId: Long,
        @RequestBody commentRequest: UpdateCommentRequest,
    ): ResponseEntity<CommentResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(commentService.updateComment(todoCardId, commentId, commentRequest))
    }

    @DeleteMapping("/{commentId}")
    fun deleteComment(
        @PathVariable todoCardId: Long,
        @PathVariable commentId: Long,
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .body(commentService.deleteComment(todoCardId, commentId))
    }
}