package com.bitter.dao.models.common

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalTime

class TimeFrame {

    @JsonProperty("start_time")
    @JsonFormat(pattern = "HH:mm")
    var startTime: LocalTime? = null

    @JsonProperty("end_time")
    @JsonFormat(pattern = "HH:mm")
    var endTime: LocalTime? = null

}