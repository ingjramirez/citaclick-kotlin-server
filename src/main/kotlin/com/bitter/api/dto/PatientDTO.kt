package com.bitter.api.dto

import com.bitter.dao.models.User
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

class PatientDTO (

    @JsonIgnoreProperties(value = ["password", "role", "patientIds", "professional_profile"])
    var user: User

)
