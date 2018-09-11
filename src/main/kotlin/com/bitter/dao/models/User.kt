package com.bitter.dao.models

import com.bitter.dao.enums.Gender
import com.bitter.dao.enums.Role
import com.bitter.dao.models.common.*
import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.mongodb.core.index.TextIndexed
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*
import kotlin.collections.ArrayList

@Document(collection = "users")
open class User : BaseModel {

    constructor() {}

    @TextIndexed
    var email: String? = null

    var password: String = ""

    @JsonProperty("first_name")
    var firstName: String = ""

    @JsonProperty("middle_name")
    var middleName: String = ""

    @JsonProperty("last_name")
    var lastName: String = ""

    var phones: ArrayList<Phone> = ArrayList()

    var addresses: ArrayList<Address> = ArrayList()

    @JsonProperty("date_of_birth")
    @JsonFormat(pattern = "yyyy-MM-dd")
    var dateOfBirth: Date? = null

    var gender: Gender? = null

    var height: Float = 0.0f

    var weight: Float = 0.0f

    @JsonProperty("professional_profile")
    var profile: ProfessionalProfile? = null

    @JsonProperty("case_file")
    var caseFile: CaseFile? = null

    var patientIds: ArrayList<String>? = null

    var role: Role = Role.PATIENT

}