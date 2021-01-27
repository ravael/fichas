package com.consulta.fichas

import org.apache.catalina.filters.CorsFilter
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.core.Ordered
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@SpringBootApplication
open class FichasApplication

fun main(args: Array<String>) {
	runApplication<FichasApplication>(*args)
}
