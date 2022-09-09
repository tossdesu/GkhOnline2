package com.tossdesu.gkhonline2.domain

interface SettingsRepository {

    suspend fun savePushToken(token: String)

    suspend fun getPushToken(): String

    suspend fun savePushServiceType(type: String)

    suspend fun getPushServiceType(): String

    suspend fun saveAppInstallTime(timeInMillis: String)

    suspend fun getDeviceId(): String

    suspend fun getLastOpenAccount(): Long

    suspend fun deleteLastOpenAccount()

    suspend fun saveLastOpenAccount(accountId: Long)

    suspend fun getAccountsCardType(): Int

    suspend fun saveAccountsCardType(type: Int)
}