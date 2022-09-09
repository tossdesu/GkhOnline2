package com.tossdesu.gkhonline2.domain

import com.tossdesu.gkhonline2.domain.entity.*

interface AccountRepository {

    /** ACCOUNT **/
    suspend fun signIn(login: String, password: String, deviceId: String)

    suspend fun addAccount(account: Account)

    suspend fun getAccount(accountId: Long): AccountInExplorer

    suspend fun findByDomainAndLogin(domain: String, login: String): AccountExists?

    suspend fun getAllAccounts(): List<Account>

    suspend fun updateAccount(accountUpdate: AccountUpdate)

    suspend fun deleteAccount(accountId: Long)

    suspend fun clearSession(accountId: Long)

    suspend fun updateLoginTime(id: Long, time: Long)

    suspend fun getDomainsOfOpenAccounts(): List<String>

    /** HISTORY **/
    suspend fun getHistory(accountId: Long): List<History>

    suspend fun saveHistory(history: List<HistorySave>)

    suspend fun deleteHistory(accountId: Long)

    /** MENU ITEMS **/
    suspend fun getMenu(accountId: Long): List<MenuItem>

    suspend fun deleteMenu(accountId: Long)

    suspend fun saveMenu(menu: List<MenuItem>)
}