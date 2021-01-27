package com.consulta.fichas.service

import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class JwtUserDetailsService : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        return if ("admin" == username) {
            User(
                "admin", "$2a$10\$ixlPY3AAd4ty1l6E2IsQ9OFZi2ba9ZQE0bP7RFcGIWNhyFrrT3YUi",
                ArrayList()
            )
        } else {
            throw UsernameNotFoundException("User not found with username: $username")
        }
    }

}