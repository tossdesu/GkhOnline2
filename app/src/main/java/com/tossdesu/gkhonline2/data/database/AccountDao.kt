package com.tossdesu.gkhonline2.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.tossdesu.gkhonline2.data.database.entity.*

@Dao
interface AccountDao {

    /** ACCOUNT **/
    @Insert
    suspend fun addAccount(accountDbEntity: AccountDbEntity)

    @Query("SELECT domain, login, company, contact, session FROM ${AccountDbEntity.NAME} WHERE id = :accountId LIMIT 1")
    suspend fun getAccount(accountId: Long): AccountInExplorerTuple

    @Query("SELECT id, session FROM ${AccountDbEntity.NAME} WHERE domain = :domain AND login = :login LIMIT 1")
    suspend fun findByDomainAndLogin(domain: String, login: String): AccountExistsTuple?

    @Query("SELECT * FROM ${AccountDbEntity.NAME}")
    suspend fun getAllAccounts(): List<AccountDbEntity>

    @Update(entity = AccountDbEntity::class)
    suspend fun updateAccount(accountUpdateTuple: AccountUpdateTuple)

    @Query("DELETE FROM ${AccountDbEntity.NAME} WHERE id = :accountId")
    suspend fun deleteAccount(accountId: Long)

    @Query("UPDATE ${AccountDbEntity.NAME} SET session = '' WHERE id = :accountId")
    suspend fun deleteSession(accountId: Long)

    @Update(entity = AccountDbEntity::class)
    suspend fun updateLoginTime(updateLoginTimeTuple: AccountUpdateLoginTimeTuple)

    @Query("SELECT domain FROM ${AccountDbEntity.NAME} WHERE session != ''")
    suspend fun getDomainsOfOpenAccounts(): List<String>

    /** HISTORY **/
    @Query("SELECT * FROM ${HistoryDbEntity.NAME} WHERE account_id = :accountId")
    suspend fun getHistory(accountId: Long): List<HistoryDbEntity>

    @Insert
    suspend fun saveHistory(history: List<HistoryDbEntity>)

    @Query("DELETE FROM ${HistoryDbEntity.NAME} WHERE account_id = :accountId")
    suspend fun deleteHistory(accountId: Long)

    /** MENU ITEMS **/
    @Query("SELECT * FROM ${MenuItemsDbEntity.NAME} WHERE account_id = :accountId")
    suspend fun getMenu(accountId: Long): List<MenuItemsDbEntity>

    @Query("DELETE FROM ${MenuItemsDbEntity.NAME} WHERE account_id = :accountId")
    suspend fun deleteMenu(accountId: Long)

    @Insert
    suspend fun saveMenu(menu: List<MenuItemsDbEntity>)
}