package com.bitter.service

import com.bitter.dao.models.User
import com.bitter.dao.models.common.Error
import org.springframework.http.ResponseEntity
import java.util.*

interface UsersService {

    fun findOne(id:String): ResponseEntity<*>

    fun findOneByEmail(email:String?): User?

    fun addOne(user: User): ResponseEntity<*>

    fun findUserById(id: String): Optional<User?>

    fun validateUserBody(user:User) : Error?

}