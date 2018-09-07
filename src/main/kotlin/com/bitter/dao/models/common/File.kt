package com.bitter.dao.models.common

import com.fasterxml.jackson.annotation.JsonProperty

class File {

    var url: String = ""

    @JsonProperty("file_name")
    var fileName: String = ""

    @JsonProperty("file_description")
    var fileDescription: String? = null

    @JsonProperty("file_type")
    var fileType: String? = null

}