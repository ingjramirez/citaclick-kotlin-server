package com.bitter.api.controllers

import com.bitter.dao.models.common.ProfessionalProfile
import com.bitter.service.ProfessionalService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/professionals")
class ProfessionalsController {

    @Autowired
    lateinit var professionalService: ProfessionalService

    @PutMapping("/{professionalId}/updateProfessionalProfile")
    fun updateProfessionalProfile(@PathVariable professionalId: String,
                                  @RequestBody professionalProfile: ProfessionalProfile) : ResponseEntity<*> {
        return professionalService.updateProfessionalProfile(professionalId, professionalProfile)
    }

}