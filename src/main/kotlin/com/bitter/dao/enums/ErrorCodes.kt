package com.bitter.dao.enums


enum class ErrorCodes(val errorCode: Int, val description: String) {

    EMAIL_ALREADY_EXISTS(1, "Email already exists in user table. ")

}