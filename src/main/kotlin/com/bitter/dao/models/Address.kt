package com.bitter.dao.models

import com.fasterxml.jackson.annotation.JsonProperty

class Address {

    var street : String = ""

    @JsonProperty("house_number")
    var houseNumber : String = ""

    @JsonProperty("inside_number")
    var insideNumber: String? = null

    var city: String = ""

    var region: String? = null

    @JsonProperty("country_code")
    var countryCode: String = ""

    @JsonProperty("postal_code")
    var postalCode: String = ""

}