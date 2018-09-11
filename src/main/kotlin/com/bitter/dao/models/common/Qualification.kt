package com.bitter.dao.models.common

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate
import java.util.*

class Qualification {

    var description: String? = null

    @JsonProperty("obtained_at")
    @JsonFormat(pattern = "yyyy-MM-dd")
    var obtainedAt: LocalDate? = null

    @JsonProperty("qualification_place")
    var qualificationPlace: String? = null

}