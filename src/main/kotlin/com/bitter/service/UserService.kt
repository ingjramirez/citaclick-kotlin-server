package com.bitter.service

import org.springframework.http.ResponseEntity

interface UserService {

    fun findOne(id:String): ResponseEntity<*>

    fun findAll(): ResponseEntity<*>

}