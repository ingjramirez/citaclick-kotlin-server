package com.bitter.service

import com.bitter.api.dto.PatientDTO
import com.bitter.dao.models.User
import org.springframework.http.ResponseEntity

interface PatientsService {

    fun getPatients(professionalId:String): List<PatientDTO>

    fun addPatient(professionalId: String, patient: User): ResponseEntity<*>

}