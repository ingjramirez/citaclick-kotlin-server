package com.bitter.service.impl

import com.bitter.dao.enums.ErrorCodes
import com.bitter.dao.models.Appointment
import com.bitter.dao.models.User
import com.bitter.dao.repositories.UserRepository
import com.bitter.dao.models.common.Error
import com.bitter.dao.repositories.AppointmentRepository
import com.bitter.service.AppointmentService
import kotlinx.coroutines.experimental.async
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class AppointmentServiceImpl: AppointmentService {

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var appointmentRepository: AppointmentRepository

    override suspend fun addAppointment(appointment: Appointment): ResponseEntity<*> {

        if(appointment.professionalId != null && appointment.patientId != null) {
            val professional = async { findUser(appointment.professionalId!!) }
            val patient = async { findUser(appointment.patientId!!) }

            if (entitiesAreValid(professional.await(), patient.await()))
                return ResponseEntity(appointmentRepository.save(appointment), HttpStatus.CREATED)

        } else if (appointment.professionalId != null) {
            val professional = userRepository.findByIdAndDeleteIsFalse(appointment.professionalId)
            if (professional != null)
                return ResponseEntity(appointmentRepository.save(appointment), HttpStatus.CREATED)
        }

        return ResponseEntity(Error(ErrorCodes.RESOURCE_NOT_FOUND), HttpStatus.BAD_REQUEST)
    }

    override fun findAllInTimeRange(professionalId:String, fromDate:LocalDate?, throuDate: LocalDate?): List<Appointment> {
        if (fromDate != null && throuDate != null)
            return appointmentRepository.findByProfessionalIdAndDeleteIsFalseAndAppointmentDateBetween(professionalId, fromDate, throuDate)

        return ArrayList()
    }

    private fun entitiesAreValid(professional: User?, patient: User?): Boolean {
        return (professional != null && patient != null)
    }

    private suspend fun findUser(id:String): User? {
        return userRepository.findByIdAndDeleteIsFalse(id)
    }
}