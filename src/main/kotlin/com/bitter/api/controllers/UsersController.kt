package com.bitter.api.controllers

import com.bitter.dao.models.User
import com.bitter.service.UsersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController(value = "/users")
class UsersController {

    @Autowired
    lateinit var usersService: UsersService

    @PostMapping(consumes = ["application/json"])
    fun addOne(@RequestBody user: User) : ResponseEntity<*> {
        return usersService.addOne(user)
    }

}