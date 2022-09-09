package com.tossdesu.gkhonline2.data.database

import androidx.room.Dao
import androidx.room.Query
import com.tossdesu.gkhonline2.data.database.entity.SettingsDbEntity

@Dao
interface SettingsDao {

    @Query("UPDATE ${SettingsDbEntity.NAME} SET push_token_id = :token  WHERE id = 1")
    suspend fun savePushToken(token: String)

    @Query("SELECT push_token_id FROM ${SettingsDbEntity.NAME} WHERE id = 1")
    suspend fun getPushToken(): String

    @Query("UPDATE ${SettingsDbEntity.NAME} SET push_service_type = :type WHERE id = 1")
    suspend fun savePushServiceType(type: String)

    @Query("SELECT push_service_type FROM ${SettingsDbEntity.NAME} WHERE id = 1")
    suspend fun getPushServiceType(): String

    @Query("UPDATE ${SettingsDbEntity.NAME} SET device_id = :deviceId WHERE id = 1")
    suspend fun saveAppInstallTime(deviceId: String)

    @Query("SELECT device_id FROM ${SettingsDbEntity.NAME} WHERE id = 1")
    suspend fun getDeviceId(): String

    @Query("SELECT last_open_account FROM ${SettingsDbEntity.NAME} WHERE id = 1")
    suspend fun getLastOpenAccount(): Long

    @Query("UPDATE ${SettingsDbEntity.NAME} SET last_open_account = 0 WHERE id = 1")
    suspend fun deleteLastOpenAccount()

    @Query("UPDATE ${SettingsDbEntity.NAME} SET last_open_account = :accountId WHERE id = 1")
    suspend fun saveLastOpenAccount(accountId: Long)

    @Query("SELECT accounts_card_type FROM ${SettingsDbEntity.NAME} WHERE id = 1")
    suspend fun getAccountsCardType(): Int

    @Query("UPDATE ${SettingsDbEntity.NAME} SET accounts_card_type = :type WHERE id = 1")
    suspend fun saveAccountsCardType(type: Int)
}