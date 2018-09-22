package com.bitter.dao.enums


enum class ErrorCodes(val errorCode: Int, val description: String) {

    EMAIL_ALREADY_EXISTS(1, "Email already exists in user table. "),
    RESOURCE_NOT_FOUND(2, "Resource not found. "),
    INVALID_EMAIL_ADDRESS(3, "Invalid email address. "),
    AUTHORIZATION_PROBLEM(4, "Invalid user rights. ")

}