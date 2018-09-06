package com.bitter.service

import com.bitter.dao.models.User
import org.springframework.http.ResponseEntity

interface UserService {

    fun findOne(id:String): ResponseEntity<*>

    fun findOneByEmail(email:String): User?

    fun addOne(user:User): ResponseEntity<*>

    fun findAll(): ResponseEntity<*>

}