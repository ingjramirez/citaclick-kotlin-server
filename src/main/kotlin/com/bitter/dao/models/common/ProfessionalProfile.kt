package com.bitter.dao.models.common

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.DayOfWeek

class ProfessionalProfile {

    @JsonProperty("professional_licence")
    var professionalLicence: String? = null

    var qualifications: List<Qualification> = ArrayList()

    var workingHours: HashMap<DayOfWeek, List<WorkingHours>>? = null

}