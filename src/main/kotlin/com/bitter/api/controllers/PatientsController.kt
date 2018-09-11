package com.bitter.api.controllers

import com.bitter.api.dto.PatientDTO
import com.bitter.dao.models.User
import com.bitter.service.PatientsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/professionals/{professionalId}/patients")
class PatientsController {

    @Autowired
    lateinit var patientsService: PatientsService

    @GetMapping
    fun getPatients(@PathVariable professionalId: String): List<PatientDTO> {
        return patientsService.getPatients(professionalId)
    }

    @PostMapping
    fun addPatient(@PathVariable professionalId: String,
                   @RequestBody patient: User): ResponseEntity<*>? {
        return patientsService.addPatient(professionalId, patient)
    }

}