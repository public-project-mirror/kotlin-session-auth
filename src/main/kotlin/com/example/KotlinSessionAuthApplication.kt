package com.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSessionAuthApplication

fun main(args: Array<String>) {
	runApplication<KotlinSessionAuthApplication>(*args)
}
