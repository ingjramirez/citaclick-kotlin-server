package com.bitter.api.dto

import com.bitter.dao.models.User
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

class UserDTO(

    @JsonIgnoreProperties(value = ["password", "role", "patientIds"])
    var user: User

)
