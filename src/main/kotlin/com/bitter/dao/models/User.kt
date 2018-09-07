package com.bitter.dao.models

import com.bitter.dao.enums.Role
import com.bitter.dao.models.common.*
import com.fasterxml.jackson.annotation.JsonProperty
import org.jetbrains.annotations.NotNull
import org.springframework.data.mongodb.core.index.TextIndexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.*
import kotlin.collections.ArrayList

@Document(collection = "users")
open class User : BaseModel {

    constructor() {}

    @TextIndexed
    var email: String? = null

    @NotNull
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
    var dateOfBirth: Date? = null

    var phones: ArrayList<Phone>? = null

    var addresses: ArrayList<Address>? = null

    var profile: ProfessionalProfile? = null

    var caseFile: CaseFile? = null

    var role: Role? = null

}