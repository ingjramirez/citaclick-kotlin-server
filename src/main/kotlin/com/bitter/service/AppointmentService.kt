package com.bitter.service

import com.bitter.dao.models.Appointment
import org.springframework.http.ResponseEntity
import java.time.LocalDate

interface AppointmentService {

    suspend fun addAppointment(appointment: Appointment): ResponseEntity<*>

    fun findAllInTimeRange(professionalId:String, fromDate:LocalDate?, throuDate:LocalDate?): List<Appointment>

}