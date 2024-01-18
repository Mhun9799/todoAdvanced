package com.teamsparta.todoadvanced.domain.comments.service

import com.teamsparta.todoadvanced.domain.comments.dto.CommentResponse
import com.teamsparta.todoadvanced.domain.comments.dto.CreateCommentRequest
import com.teamsparta.todoadvanced.domain.comments.dto.UpdateCommentRequest

interface CommentService {
    fun createComment(todoId: Long, request: CreateCommentRequest): CommentResponse
    fun updateComment(todoId: Long, commentId: Long, request: UpdateCommentRequest): CommentResponse
    fun deleteComment(todoId: Long, commentId: Long)

}