package com.bitter.api.controllers

import com.bitter.dao.models.User
import com.bitter.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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

    @PostMapping
    fun addOne(@RequestBody user: User) : ResponseEntity<*>{
        return userService.addOne(user)
    }

}