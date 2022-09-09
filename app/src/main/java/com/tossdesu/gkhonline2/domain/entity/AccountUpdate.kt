package com.tossdesu.gkhonline2.domain.entity

data class AccountUpdate(
    val id: Long,
    val company: String,
    val contact: String,
    val session: String,
    val time: Long
)