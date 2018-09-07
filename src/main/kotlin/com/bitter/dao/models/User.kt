package com.bitter.dao.models

import com.bitter.dao.enums.Gender
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

    var password: String = ""

    @JsonProperty("first_name")
    @Field("first_name")
    var firstName: String = ""

    @JsonProperty("middle_name")
    @Field("middle_name")
    var middleName: String = ""

    @JsonProperty("last_name")
    @Field("last_name")
    var lastName: String = ""

    var phones: ArrayList<Phone> = ArrayList()

    var addresses: ArrayList<Address> = ArrayList()

    @JsonProperty("date_of_birth")
    @Field("date_of_birth")
    var dateOfBirth: Date? = null

    var gender: Gender? = null

    var height: Float = 0.0f

    var weight: Float = 0.0f

    @JsonProperty("professional_profile")
    var profile: ProfessionalProfile = ProfessionalProfile()

    @JsonProperty("case_file")
    var caseFile: CaseFile = CaseFile()

    var patientsIds: ArrayList<Int> = ArrayList()

    var role: Role? = null

}