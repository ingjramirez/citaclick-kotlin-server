package com.bitter.dao.models

import com.bitter.dao.models.common.BaseModel
import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.time.LocalTime

@Document(collection = "appointments")
class Appointment() : BaseModel() {

    @JsonProperty("professional_id")
    var professionalId: String? = null

    @JsonProperty("patient_id")
    var patientId: String? = null

    var notes: String = ""

    @JsonProperty("appointment_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    var appointmentDate: LocalDate? = null

    @JsonProperty("from_time")
    @JsonFormat(pattern = "HH:mm")
    var fromTime: LocalTime? = null

    @JsonProperty("throu_time")
    @JsonFormat(pattern = "HH:mm")
    var throuTime: LocalTime? = null

}