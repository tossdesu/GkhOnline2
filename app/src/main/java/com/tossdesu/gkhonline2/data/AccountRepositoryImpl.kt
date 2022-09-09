package com.tossdesu.gkhonline2.data

import com.tossdesu.gkhonline2.data.database.AccountDao
import com.tossdesu.gkhonline2.data.database.entity.*
import com.tossdesu.gkhonline2.data.network.ApiService
import com.tossdesu.gkhonline2.data.network.entity.SignInRequestBody
import com.tossdesu.gkhonline2.domain.AccountRepository
import com.tossdesu.gkhonline2.domain.entity.*
import javax.inject.Inject

class AccountRepositoryImpl @Inject constructor(
    private val accountDao: AccountDao,
    private val apiService: ApiService
) : AccountRepository {

    /** ACCOUNT **/
    override suspend fun signIn(login: String, password: String, deviceId: String) {
        val signInRequestBody = SignInRequestBody(login, password, deviceId)
        apiService.signIn(signInRequestBody)
    }

    override suspend fun addAccount(account: Account) {
        val accountDbList = AccountDbEntity.fromAccount(account)
        accountDao.addAccount(accountDbList)
    }

    override suspend fun getAccount(accountId: Long): AccountInExplorer {
        val tuple = accountDao.getAccount(accountId)
        return tuple.toAccountInExplorer()
    }

    override suspend fun findByDomainAndLogin(domain: String, login: String): AccountExists? {
        val tuple = accountDao.findByDomainAndLogin(domain, login)
        return tuple?.toAccountExists()
    }

    override suspend fun getAllAccounts(): List<Account> {
        val accountDbList = accountDao.getAllAccounts()
        return accountDbList.map {
            it.toAccount()
        }
    }

    override suspend fun updateAccount(accountUpdate: AccountUpdate) {
        val tuple = AccountUpdateTuple.fromAccountUpdate(accountUpdate)
        accountDao.updateAccount(tuple)
    }

    override suspend fun deleteAccount(accountId: Long) {
        accountDao.deleteAccount(accountId)
    }

    override suspend fun clearSession(accountId: Long) {
        accountDao.deleteSession(accountId)
    }

    override suspend fun updateLoginTime(id: Long, time: Long) {
        val tuple = AccountUpdateLoginTimeTuple(id, time)
        accountDao.updateLoginTime(tuple)
    }

    override suspend fun getDomainsOfOpenAccounts(): List<String> {
        return accountDao.getDomainsOfOpenAccounts()
    }

    /** HISTORY **/
    override suspend fun getHistory(accountId: Long): List<History> {
        val tupleList = accountDao.getHistory(accountId)
        return tupleList.map {
            it.toHistory()
        }
    }

    override suspend fun saveHistory(history: List<HistorySave>) {
        val historyDbList = history.map {
            HistoryDbEntity.fromHistorySave(it)
        }
        accountDao.saveHistory(historyDbList)
    }

    override suspend fun deleteHistory(accountId: Long) {
        accountDao.deleteHistory(accountId)
    }

    /** MENU ITEMS **/
    override suspend fun getMenu(accountId: Long): List<MenuItem> {
        val menuDbList = accountDao.getMenu(accountId)
        return menuDbList.map {
            it.toMenuItem()
        }
    }

    override suspend fun deleteMenu(accountId: Long) {
        accountDao.deleteMenu(accountId)
    }

    override suspend fun saveMenu(menu: List<MenuItem>) {
        val menuDbList = menu.map {
            MenuItemsDbEntity.fromMenuItem(it)
        }
        accountDao.saveMenu(menuDbList)
    }
}