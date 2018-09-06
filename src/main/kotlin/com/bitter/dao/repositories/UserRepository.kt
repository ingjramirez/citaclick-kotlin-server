package com.bitter.dao.repositories

import com.bitter.dao.models.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository <User, String> {

    fun findByEmail(email:String) : User?

}