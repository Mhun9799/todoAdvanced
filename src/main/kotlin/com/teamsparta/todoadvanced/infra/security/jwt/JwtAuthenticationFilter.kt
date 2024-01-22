package com.teamsparta.todoadvanced.infra.security.jwt

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.apache.tomcat.util.net.openssl.ciphers.Authentication
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthenticationFilter(
    private val jwtPlugin: JwtPlugin,
) : OncePerRequestFilter() {

    companion object {
        private val BEARER_PATTERN = Regex("^Bearer (.+?)$")
    }

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val jwt = request.getBearerToken()
        if (jwt != null){
            jwtPlugin.validateToken(jwt)
                .onSuccess {
                    val userId = it.payload.subject.toLong()
                    val userName = it.payload.get("username",String::class.java)

                }
        }
    }

    private fun HttpServletRequest.getBearerToken(): String? {
        val headerValue = this.getHeader(HttpHeaders.AUTHORIZATION) ?: return null
        return BEARER_PATTERN.find(headerValue)?.groupValues?.get(1)
    }
}