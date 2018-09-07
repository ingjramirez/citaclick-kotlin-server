package com.bitter.dao.models.common

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.OffsetDateTime

class Qualification {

    var description: String? = null

    @JsonProperty("from_date")
    var fromDate: OffsetDateTime? = null

    @JsonProperty("throu_date")
    var throuDate: OffsetDateTime? = null

    @JsonProperty("qualification_place")
    var qualificationPlace: String? = null

}