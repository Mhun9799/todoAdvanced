package com.teamsparta.todoadvanced.infra.security.jwt

import com.teamsparta.todoadvanced.infra.security.UserPrincipal
import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.web.authentication.WebAuthenticationDetails
import java.io.Serializable

class JwtAuthenticationToken(
    private val principal: UserPrincipal,
    details: WebAuthenticationDetails,
):  AbstractAuthenticationToken(emptyList<GrantedAuthority>()), Serializable {
    init {
        super.setAuthenticated(true)
        super.setDetails(details)
    }
    override fun getPrincipal() = principal

    override fun getCredentials() = null

    override fun isAuthenticated(): Boolean {
        return true
    }
}