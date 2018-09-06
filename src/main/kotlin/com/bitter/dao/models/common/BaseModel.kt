package com.bitter.dao.models.common

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.*
import java.util.*

open class BaseModel {

    @Id
    var id: String? = null

    @CreatedBy
    @JsonIgnore
    var createdBy: String? = null

    @CreatedDate
    @JsonIgnore
    var createdAt: Date = Date();

    @LastModifiedBy
    @JsonIgnore
    var updatedBy: String = ""

    @LastModifiedDate
    @JsonIgnore
    var updatedAt: Date = Date()

    @Version
    private var version: Long? = null

    @JsonIgnore
    var delete: Boolean = false

    constructor() {}

    constructor(
        id: String,
        createdBy: String,
        createdAt: Date,
        updatedBy: String,
        updatedAt: Date,
        version: Long?,
        delete: Boolean
    ) {
        this.id = id
        this.createdBy = createdBy
        this.createdAt = createdAt
        this.updatedBy = updatedBy
        this.updatedAt = updatedAt
        this.version = version
        this.delete = delete
    }
}