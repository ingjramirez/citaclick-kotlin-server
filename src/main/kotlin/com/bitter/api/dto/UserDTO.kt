package com.bitter.api.dto

import com.bitter.dao.models.User
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

class UserDTO(

    @JsonIgnoreProperties("password")
    var user: User

)
