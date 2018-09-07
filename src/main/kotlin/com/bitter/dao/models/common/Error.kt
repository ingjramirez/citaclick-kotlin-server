package com.bitter.dao.models.common

import com.bitter.dao.enums.ErrorCodes
import com.fasterxml.jackson.annotation.JsonProperty

class Error {

    @JsonProperty("error_code")
    var errorCode: Int = 0

    @JsonProperty("error_description")
    var errorDescription: String = ""

    constructor() {}

    constructor(errorCodes: ErrorCodes) {
        this.errorCode = errorCodes.errorCode
        this.errorDescription = errorCodes.description
    }

}