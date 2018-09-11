package com.bitter.dao.repositories

import com.bitter.dao.models.Appointment
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface AppointmentRepository: MongoRepository<Appointment, String> {

    fun findByProfessionalIdAndDeleteIsFalseAndAppointmentDateBetween(professionalId:String, fromDate: LocalDate, throuDate: LocalDate): List<Appointment>

}