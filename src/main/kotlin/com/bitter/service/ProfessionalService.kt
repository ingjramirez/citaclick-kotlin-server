package com.bitter.service

import com.bitter.dao.models.common.ProfessionalProfile
import org.springframework.http.ResponseEntity

interface ProfessionalService {

    fun updateProfessionalProfile(professionalId: String, professionalProfile: ProfessionalProfile): ResponseEntity<*>

}