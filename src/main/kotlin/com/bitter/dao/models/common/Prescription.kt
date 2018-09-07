package com.bitter.dao.models.common

import com.fasterxml.jackson.annotation.JsonProperty

class Prescription {

    @JsonProperty("medicament_dosis")
    var medicamentName: String = ""

    @JsonProperty("medicament_dosis")
    var medicamentDosis: Long = 0L

    @JsonProperty("every_number")
    var everyNumber: Int = 0

    @JsonProperty("every_time_frame")
    var everyTimeFrame: TimeFrame? = null

    @JsonProperty("during_number")
    var duringNumber: Int = 0

    @JsonProperty("during_time_frame")
    var duringTimeFrame: TimeFrame? = null


}