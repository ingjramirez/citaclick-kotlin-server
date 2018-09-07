package com.bitter.dao.models.common

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.OffsetDateTime

class WorkingHours {

    @JsonProperty("start_time")
    var startTime: OffsetDateTime? = null

    @JsonProperty("end_time")
    var endTime: OffsetDateTime? = null

}