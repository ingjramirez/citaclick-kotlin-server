package com.bitter.service.impl

import com.bitter.api.dto.UserDTO
import com.bitter.config.utils.FunctionsUtils
import com.bitter.dao.enums.ErrorCodes
import com.bitter.dao.models.User
import com.bitter.dao.models.common.Error
import com.bitter.dao.repositories.UserRepository
import com.bitter.service.UsersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*
import org.springframework.security.core.authority.SimpleGrantedAuthority



@Service("user_service")
class UsersServiceImpl: UsersService, UserDetailsService {

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var functionsUtils: FunctionsUtils

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    override fun findOne(id: String): ResponseEntity<*> {

        val result = findUserById(id)
        return if (result.isPresent)
            ResponseEntity(UserDTO(result.get()), HttpStatus.OK)
        else
            ResponseEntity("Entity Not found", HttpStatus.NOT_FOUND)

    }

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(email: String): UserDetails {

        val user = userRepository.findByEmailAndDeleteIsFalse(email)
            ?: throw UsernameNotFoundException("Could not find account with email: $email!")

        return org.springframework.security.core.userdetails.User(
            user.email,
            user.password,
            getAuthority(user)
        )
    }

    private fun getAuthority(user:User): List<GrantedAuthority> {
        return Arrays.asList(SimpleGrantedAuthority(user.role.toString()))
    }

    override fun findOneByEmail(email: String?): User? {
        return userRepository.findByEmailAndDeleteIsFalse(email)
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
        if (user.email != null && !functionsUtils.isEmailValid(user.email))
            return Error(ErrorCodes.INVALID_EMAIL_ADDRESS)

        return null
    }

    private fun userWithEncryptedPassword (user: User): User {

        user.password = passwordEncoder.encode(user.password)
        return user
    }


}