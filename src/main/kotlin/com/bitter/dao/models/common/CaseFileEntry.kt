package com.bitter.dao.models.common

import org.springframework.data.annotation.CreatedDate
import java.time.OffsetDateTime

class CaseFileEntry {

    var entryText: String = ""

    var prescriptions: ArrayList<Prescription>? = null

    var attachments: ArrayList<File>? = null

    @CreatedDate
    var createdAt: OffsetDateTime = OffsetDateTime.now()

}