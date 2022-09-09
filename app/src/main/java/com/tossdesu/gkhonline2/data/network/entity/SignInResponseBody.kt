package com.tossdesu.gkhonline2.data.network.entity

data class SignInResponseBody(
    val status: Int,
    val message: String,
    val domain: String,
    val company: String,
    val contact: String,
    val session: String,
)
