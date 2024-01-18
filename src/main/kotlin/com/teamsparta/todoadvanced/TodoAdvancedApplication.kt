package com.teamsparta.todoadvanced

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class TodoAdvancedApplication

fun main(args: Array<String>) {
    runApplication<TodoAdvancedApplication>(*args)
}
