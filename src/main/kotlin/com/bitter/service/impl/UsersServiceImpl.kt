package com.bitter.service.impl

import com.bitter.api.dto.UserDTO
import com.bitter.config.utils.isEmailValid
import com.bitter.dao.enums.ErrorCodes
import com.bitter.dao.models.User
import com.bitter.dao.models.common.Error
import com.bitter.dao.repositories.UserRepository
import com.bitter.service.UsersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsersServiceImpl: UsersService {

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    override fun findOne(id: String): ResponseEntity<*> {

        val result = findUserById(id)
        return if (result.isPresent)
            ResponseEntity(UserDTO(result.get()), HttpStatus.OK)
        else
            ResponseEntity("Entity Not found", HttpStatus.NOT_FOUND)

    }

    override fun findOneByEmail(email: String?): User? {
        return userRepository.findByEmail(email)
    }

    override fun addOne(user: User): ResponseEntity<*> {

        val error = validateUserBody(user)
        if (error != null)
            return ResponseEntity(error, HttpStatus.BAD_REQUEST)

        userRepository.save(userWithEncryptedPassword(user))
        return ResponseEntity(UserDTO(user), HttpStatus.CREATED)
    }

    override fun findUserById(id: String): Optional<User?> {

        return userRepository.findById(id)
    }

    override fun validateUserBody(user:User) : Error? {

        val userByEmail = findOneByEmail(user.email)
        if (userByEmail != null)
            return Error(ErrorCodes.EMAIL_ALREADY_EXISTS)
        if (user.email != null && !isEmailValid(user.email))
            return Error(ErrorCodes.INVALID_EMAIL_ADDRESS)

        return null
    }

    private fun userWithEncryptedPassword (user: User): User {

        user.password = passwordEncoder.encode(user.password)
        return user
    }


}