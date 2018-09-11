package com.bitter.dao.repositories

import com.bitter.dao.models.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.CrudRepository

interface UserRepository : MongoRepository <User, String> {

    fun findByIdAndDeleteIsFalse(id:String?): User?

    fun findByEmailAndDeleteIsFalse(email:String?) : User?

}