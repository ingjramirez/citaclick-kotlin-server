package com.bitter.service.impl

import com.bitter.api.dto.UserDTO
import com.bitter.dao.models.User
import com.bitter.dao.repositories.UserRepository
import com.bitter.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    override fun findOne(id: String): ResponseEntity<*> {

        val result = userRepository.findById(id)
        if (result.isPresent)
            return ResponseEntity(UserDTO(result.get()), HttpStatus.OK)
        else
            return ResponseEntity("Entity Not found", HttpStatus.NOT_FOUND)

    }

    override fun findAll(): ResponseEntity<*> {

        val users = userRepository.findAll().asSequence().toList().map { user -> UserDTO(user) }
        return ResponseEntity(users, HttpStatus.OK)
    }

    fun userWithEncryptedPassword (user: User): User {



        return user
    }

}
