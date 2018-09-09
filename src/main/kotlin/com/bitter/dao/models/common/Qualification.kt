package com.bitter.dao.models.common

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

class Qualification {

    var description: String? = null

    @JsonProperty("obtained_at")
    var obtainedAt: Date? = null

    @JsonProperty("qualification_place")
    var qualificationPlace: String? = null

}