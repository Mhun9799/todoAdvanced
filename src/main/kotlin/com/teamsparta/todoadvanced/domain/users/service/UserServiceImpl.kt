package com.teamsparta.todoadvanced.domain.users.service

import com.teamsparta.todoadvanced.domain.exception.ModelNotFoundException
import com.teamsparta.todoadvanced.domain.users.dto.CreateUserRequest
import com.teamsparta.todoadvanced.domain.users.dto.LoginRequest
import com.teamsparta.todoadvanced.domain.users.dto.LoginResponse
import com.teamsparta.todoadvanced.domain.users.dto.UserResponse
import com.teamsparta.todoadvanced.domain.users.model.User
import com.teamsparta.todoadvanced.domain.users.repository.UserRepository
import com.teamsparta.todoadvanced.infra.security.jwt.JwtPlugin
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtPlugin: JwtPlugin,
) : UserService {

    override fun login(request: LoginRequest): LoginResponse {
        val user = userRepository.findByName(request.username)
            ?: throw ModelNotFoundException("user", null)

        if (passwordEncoder.matches(request.password, user.password)) {
            throw ModelNotFoundException("user", null)
        }

        return LoginResponse(
            accessToken = jwtPlugin.generateAccessToken(
                subject = user.id.toString(),
                email = user.username,
            )
        )
    }

    override fun createUser(request: CreateUserRequest): UserResponse {
        val user = User(
            username = request.username,
            password = passwordEncoder.encode(request.password),
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