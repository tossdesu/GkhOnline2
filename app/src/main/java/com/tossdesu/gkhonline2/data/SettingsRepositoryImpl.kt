package com.tossdesu.gkhonline2.data

import com.tossdesu.gkhonline2.data.database.SettingsDao
import com.tossdesu.gkhonline2.domain.SettingsRepository
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(
    private val settingsDao: SettingsDao
) : SettingsRepository {

    override suspend fun savePushToken(token: String) {
        settingsDao.savePushToken(token)
    }

    override suspend fun getPushToken(): String {
        return settingsDao.getPushToken()
    }

    override suspend fun savePushServiceType(type: String) {
        settingsDao.savePushServiceType(type)
    }

    override suspend fun getPushServiceType(): String {
        return settingsDao.getPushServiceType()
    }

    override suspend fun saveAppInstallTime(timeInMillis: String) {
        settingsDao.saveAppInstallTime(timeInMillis)
    }

    override suspend fun getDeviceId(): String {
        return settingsDao.getDeviceId()
    }

    override suspend fun getLastOpenAccount(): Long {
        return settingsDao.getLastOpenAccount()
    }

    override suspend fun deleteLastOpenAccount() {
        settingsDao.deleteLastOpenAccount()
    }

    override suspend fun saveLastOpenAccount(accountId: Long) {
        settingsDao.saveLastOpenAccount(accountId)
    }

    override suspend fun getAccountsCardType(): Int {
        return settingsDao.getAccountsCardType()
    }

    override suspend fun saveAccountsCardType(type: Int) {
        settingsDao.saveAccountsCardType(type)
    }
}