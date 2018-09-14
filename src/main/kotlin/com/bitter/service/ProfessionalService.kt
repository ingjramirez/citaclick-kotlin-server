package com.bitter.service

import com.bitter.dao.models.User
import com.bitter.dao.models.common.ProfessionalProfile
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity

interface ProfessionalService {

    fun updateProfessionalProfile(professionalId: String, professionalProfile: ProfessionalProfile): ResponseEntity<*>

    fun findAllProfessionals(pageable: Pageable): ResponseEntity<*>

    fun findProfessional(id:String): ResponseEntity<*>
}