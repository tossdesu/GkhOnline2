package com.tossdesu.gkhonline2.data.database.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.tossdesu.gkhonline2.data.database.entity.AccountDbEntity.Companion.NAME
import com.tossdesu.gkhonline2.domain.entity.Account

@Entity(
    tableName = NAME,
    indices = [
        Index("domain", "login", unique = true)
    ]
)
data class AccountDbEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val domain: String,
    val login: String,
    val company: String,
    val contact: String,
    val session: String,
    val time: Long
) {

    fun toAccount() = Account(
        id = id,
        domain = domain,
        login = login,
        company = company,
        contact = contact,
        isLogin = session.isNotEmpty(),
        session = session,
        time = time
    )

    companion object {

        const val NAME = "account"

        fun fromAccount(account: Account) = AccountDbEntity(
            id = account.id,
            domain = account.domain,
            login = account.login,
            company = account.company,
            contact = account.contact,
            session = account.session,
            time = account.time
        )
    }
}