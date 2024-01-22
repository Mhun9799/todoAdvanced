package com.teamsparta.todoadvanced.infra.security.jwt

import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.core.GrantedAuthority
import java.io.Serializable

class JwtAuthenticationToken():  AbstractAuthenticationToken(emptyList<GrantedAuthority>()), Serializable {
    override fun getCredentials(): Any {
        TODO("Not yet implemented")
    }

    override fun getPrincipal(): Any {
        TODO("Not yet implemented")
    }
}