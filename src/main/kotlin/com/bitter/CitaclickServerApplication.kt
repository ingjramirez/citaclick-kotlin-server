package com.bitter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CitaclickServerApplication

fun main(args: Array<String>) {
    runApplication<CitaclickServerApplication>(*args)
}
