package com.bitter.service.impl

import com.bitter.api.dto.UserDTO
import com.bitter.dao.enums.ErrorCodes
import com.bitter.dao.models.Error
import com.bitter.dao.models.User
import com.bitter.dao.repositories.UserRepository
import com.bitter.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    override fun findOne(id: String): ResponseEntity<*> {

        val result = userRepository.findById(id)
        return if (result.isPresent)
            ResponseEntity(UserDTO(result.get()), HttpStatus.OK)
        else
            ResponseEntity("Entity Not found", HttpStatus.NOT_FOUND)

    }

    override fun findOneByEmail(email: String): User? {
        return userRepository.findByEmail(email)
    }

    override fun addOne(user: User): ResponseEntity<*> {

        val userByEmail = findOneByEmail(user.email)
        if (userByEmail != null)
            return ResponseEntity(Error(ErrorCodes.EMAIL_ALREADY_EXISTS), HttpStatus.BAD_REQUEST)

        userRepository.save(userWithEncryptedPassword(user))
        return ResponseEntity(UserDTO(user), HttpStatus.CREATED)
    }

    override fun findAll(): ResponseEntity<*> {

        val users = userRepository.findAll().asSequence().toList().map { user -> UserDTO(user) }
        return ResponseEntity(users, HttpStatus.OK)
    }

    fun userWithEncryptedPassword (user: User): User {

        user.password = passwordEncoder.encode(user.password)
        return user
    }

}
