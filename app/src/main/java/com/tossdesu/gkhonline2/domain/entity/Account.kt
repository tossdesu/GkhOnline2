package com.tossdesu.gkhonline2.domain.entity

data class Account(
    val id: Long,
    val domain: String,
    val login: String,
    val company: String,
    val contact: String,
    val isSignIn: Boolean,
    val session: String,
    val lastSignIn: String
)