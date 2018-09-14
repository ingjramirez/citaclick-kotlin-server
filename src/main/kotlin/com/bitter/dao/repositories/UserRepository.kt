package com.bitter.dao.repositories

import com.bitter.dao.enums.Role
import com.bitter.dao.models.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

import org.springframework.data.repository.PagingAndSortingRepository

interface UserRepository : PagingAndSortingRepository <User, String> {

    fun findByIdAndDeleteIsFalse(id:String?): User?

    fun findByEmailAndDeleteIsFalse(email:String?) : User?

    fun findUsersByRole(pageable: Pageable, role:Role): Page<User>

}