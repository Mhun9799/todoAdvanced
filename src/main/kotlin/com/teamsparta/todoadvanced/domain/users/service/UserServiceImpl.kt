package com.teamsparta.todoadvanced.domain.users.service

import com.teamsparta.todoadvanced.domain.comments.dto.CommentResponse
import com.teamsparta.todoadvanced.domain.comments.model.Comment
import com.teamsparta.todoadvanced.domain.users.dto.CreateUserRequest
import com.teamsparta.todoadvanced.domain.users.dto.UserResponse
import com.teamsparta.todoadvanced.domain.users.model.User
import com.teamsparta.todoadvanced.domain.users.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {
    override fun createUser(request: CreateUserRequest): UserResponse {
       val user = User(
           username = request.username,
           password = request.password,
       )
        val createdUser = userRepository.save(user)

        return createdUser.toResponse()
    }
}

@Transactional
fun User.toResponse(): UserResponse {
    return UserResponse(
        id = id!!,
        username = username,
    )
}