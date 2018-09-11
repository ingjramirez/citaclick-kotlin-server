package com.bitter.service.impl

import com.bitter.api.dto.PatientDTO
import com.bitter.dao.enums.ErrorCodes
import com.bitter.dao.models.User
import com.bitter.dao.models.common.CaseFile
import com.bitter.dao.models.common.Error
import com.bitter.dao.repositories.UserRepository
import com.bitter.service.PatientsService
import com.bitter.service.UsersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class PatientServiceImpl: PatientsService {

    @Autowired
    lateinit var userService: UsersService

    @Autowired
    lateinit var userRepository: UserRepository

    override fun getPatients(professionalId:String): List<PatientDTO> {

        val professionalOptional = userService.findUserById(professionalId)
        return if (professionalOptional.isPresent){
            val patientIds = professionalOptional.get().patientIds
            if (patientIds != null) {
                val patients = ArrayList<PatientDTO> ()
                for (id : String in patientIds){
                    val patient = userRepository.findById(id)
                    if (patient.isPresent)
                        patients.add(PatientDTO(patient.get()))
                }
                patients
            } else
                ArrayList()
        } else
            ArrayList()
    }

    override fun addPatient(professionalId: String, patient: User): ResponseEntity<*> {

        val professional = userService.findUserById(professionalId)
        return if (!professional.isPresent)
            ResponseEntity(Error(ErrorCodes.RESOURCE_NOT_FOUND), HttpStatus.NOT_FOUND)
        else {
            val tmpProfessional = professional.get()
            var patientIds = tmpProfessional.patientIds
            if (patientIds == null)
                patientIds = ArrayList()

            val checkIfPresent = userRepository.findByEmailAndDeleteIsFalse(patient.email)

            if (checkIfPresent == null) {
                patient.caseFile = CaseFile()
                val createdPatient = userRepository.save(patient)
                patientIds.add(createdPatient.id!!)
            } else {
                patientIds.add(checkIfPresent.id!!)
            }

            tmpProfessional.patientIds = patientIds
            userRepository.save(tmpProfessional)

            ResponseEntity("Patient added successfully", HttpStatus.OK)
        }
    }

}