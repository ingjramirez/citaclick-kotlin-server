package com.bitter.dao.models.common

import com.fasterxml.jackson.annotation.JsonProperty

class CaseFile {

    @JsonProperty("case_file_entries")
    var caseFileEntries: ArrayList<CaseFileEntry>? = ArrayList()

}