package com.bitter.dao.models

import com.bitter.dao.models.common.BaseModel
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.mongodb.core.index.TextIndexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.*

@Document(collection = "users")
class User : BaseModel {

    @TextIndexed
    var email: String = ""

    var password: String = ""

    @JsonProperty("first_name")
    @Field("first_name")
    var firstName: String = ""

    @JsonProperty("middle_name")
    @Field("middle_name")
    var middleName: String? = null

    @JsonProperty("last_name")
    @Field("last_name")
    var lastName: String = ""

    @JsonProperty("date_of_birth")
    @Field("date_of_birth")
    var dateOfBirth: Date = Date()

    var phones: List<Phone>? = null

    var addresses: List<Address>? = null

    constructor() {}

    constructor(
        email: String,
        password: String,
        firstName: String,
        middleName: String,
        lastName: String,
        dateOfBirth: Date,
        phones: List<Phone>?,
        addresses: List<Address>?
    ) {
        this.email = email
        this.password = password
        this.firstName = firstName
        this.middleName = middleName
        this.lastName = lastName
        this.dateOfBirth = dateOfBirth
        this.phones = phones
        this.addresses = addresses
    }

}