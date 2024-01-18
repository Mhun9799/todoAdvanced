package com.teamsparta.todoadvanced.domain.comments.service

import com.teamsparta.todoadvanced.domain.comments.dto.CommentResponse
import com.teamsparta.todoadvanced.domain.comments.dto.CreateCommentRequest
import com.teamsparta.todoadvanced.domain.comments.dto.UpdateCommentRequest
import com.teamsparta.todoadvanced.domain.comments.model.Comment
import com.teamsparta.todoadvanced.domain.comments.repository.CommentRepository
import com.teamsparta.todoadvanced.domain.exception.ModelNotFoundException
import com.teamsparta.todoadvanced.domain.todocards.repository.TodoCardRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class CommentServiceImpl(
    private val commentRepository: CommentRepository,
    private val todoRepository: TodoCardRepository,
) : CommentService {
    override fun createComment(todoId: Long, request: CreateCommentRequest): CommentResponse {
        val todoCard = todoRepository.findByIdOrNull(todoId)
            ?: throw ModelNotFoundException("todoCard", todoId)
        return commentRepository.save(
            Comment(
                content = request.content,
                authorName = todoCard.authorName,
                password = request.password,
                todoCard = todoCard,
            )
        ).toResponse()
    }

    @Transactional
    override fun updateComment(todoId: Long, commentId: Long, request: UpdateCommentRequest): CommentResponse {
        val todoCard = todoRepository.findByIdOrNull(todoId)
            ?: throw ModelNotFoundException("todoCard", todoId)
        val comment = commentRepository.findByIdOrNull(commentId)
            ?: throw ModelNotFoundException("comment", commentId)
        return commentRepository.save(comment).toResponse()
    }

    @Transactional
    override fun deleteComment(todoId: Long, commentId: Long, authorName: String, password: String) {
        val comment = commentRepository.findByIdOrNull(commentId)
            ?: throw ModelNotFoundException("comment", commentId)
        commentRepository.delete(comment)
    }
}

@Transactional
fun Comment.toResponse(): CommentResponse {
    return CommentResponse(
        id = id!!,
        content = content,
        authorName = authorName,
    )
}

