package com.bitter.dao.models

import com.fasterxml.jackson.annotation.JsonProperty

class Phone {

    @JsonProperty("phone_country_code")
    var phoneCountryCode: String = ""

    @JsonProperty("phone_number")
    var phoneNumber: String = ""

}