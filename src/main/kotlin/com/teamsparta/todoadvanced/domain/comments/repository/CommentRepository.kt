package com.teamsparta.todoadvanced.domain.comments.repository

import com.teamsparta.todoadvanced.domain.comments.model.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository: JpaRepository<Comment, Long> {
}