package com.tossdesu.gkhonline2.data.network.entity

data class SignInRequestBody(
    val login: String,
    val password: String,
    val device_id: String,
)
