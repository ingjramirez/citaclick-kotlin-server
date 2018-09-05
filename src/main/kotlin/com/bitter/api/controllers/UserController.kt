package com.bitter.api.controllers

import com.bitter.api.dto.UserDTO
import com.bitter.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController {

    @Autowired
    lateinit var userService: UserService

    @GetMapping
    fun findAllUsers() : ResponseEntity<*> {
        return userService.findAll()
    }

    @GetMapping("/{id}")
    fun findOne(@PathVariable id:String) : ResponseEntity<*> {
        return userService.findOne(id)
    }

}