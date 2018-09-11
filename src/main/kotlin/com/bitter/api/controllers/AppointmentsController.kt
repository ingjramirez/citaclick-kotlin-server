package com.bitter.api.controllers

import com.bitter.dao.models.Appointment
import com.bitter.service.AppointmentService
import kotlinx.coroutines.experimental.runBlocking
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.format.annotation.DateTimeFormat.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("/professionals/{professionalId}/appointments")
class AppointmentsController {

    @Autowired
    lateinit var appointmentService: AppointmentService

    @GetMapping
    fun getAppointments(
        @PathVariable("professionalId") professionalId:String,
        @RequestParam(value = "from_date") @DateTimeFormat(iso = ISO.DATE) fromDate: LocalDate?,
        @RequestParam(value = "throu_date") @DateTimeFormat(iso = ISO.DATE) throuDate: LocalDate?): List<Appointment> {

        return appointmentService.findAllInTimeRange(professionalId, fromDate, throuDate)
    }

    @PostMapping
    fun addAppointment(@PathVariable professionalId:String,
                       @RequestBody appointment: Appointment): ResponseEntity<*> {
        appointment.professionalId = professionalId
        return runBlocking { appointmentService.addAppointment(appointment) }
    }
}