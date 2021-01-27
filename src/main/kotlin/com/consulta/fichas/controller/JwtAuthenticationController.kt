package com.consulta.fichas.controller

import com.consulta.fichas.config.JwtTokenUtil
import com.consulta.fichas.models.JwtRequest
import com.consulta.fichas.models.JwtResponse
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.DisabledException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.web.bind.annotation.*
import java.lang.Exception
import java.util.*

@RestController
//@CrossOrigin
class JwtAuthenticationController(private val authenticationManager: AuthenticationManager?,
                                  private val jwtTokenUtil: JwtTokenUtil?,
                                  private val jwtInMemoryUserDetailsService: UserDetailsService?) {

    @RequestMapping(value = ["/authenticate"], method = [RequestMethod.POST])
    @Throws(Exception::class)
    fun generateAuthenticationToken(@RequestBody authenticationRequest: JwtRequest): ResponseEntity<*> {
        authenticate(authenticationRequest.username, authenticationRequest.password)
        val userDetails = jwtInMemoryUserDetailsService?.loadUserByUsername(authenticationRequest.username)
        val token: String? = jwtTokenUtil?.generateToken(userDetails!!)
        return ResponseEntity.ok<Any>(JwtResponse(token!!))
    }

    @Throws(Exception::class)
    private fun authenticate(username: String, password: String) {
        Objects.requireNonNull(username)
        Objects.requireNonNull(password)
        try {
            authenticationManager!!.authenticate(UsernamePasswordAuthenticationToken(username, password))
        } catch (e: DisabledException) {
            throw Exception("USER_DISABLED", e)
        } catch (e: BadCredentialsException) {
            throw Exception("INVALID_CREDENTIALS", e)
        }
    }
}