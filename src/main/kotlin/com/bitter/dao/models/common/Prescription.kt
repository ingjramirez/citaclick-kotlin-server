package com.bitter.dao.models.common

import com.fasterxml.jackson.annotation.JsonProperty

class Prescription {

    @JsonProperty("medicament_dosis")
    var medicamentName: String = ""

    var medicamentDosis: Long = 0L

    var everyNumber: Int = 0

    var everyTimeFrame: TimeFrame? = null

    var duringNumber: Int = 0

    var duringTimeFrame: TimeFrame? = null


}