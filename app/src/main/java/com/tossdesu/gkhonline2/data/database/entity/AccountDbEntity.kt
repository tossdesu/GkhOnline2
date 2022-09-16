package com.tossdesu.gkhonline2.data.database.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.tossdesu.gkhonline2.data.database.entity.AccountDbEntity.Companion.NAME
import com.tossdesu.gkhonline2.domain.entity.Account
import java.text.SimpleDateFormat
import java.util.*

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
        isSignIn = session.isNotEmpty(),
        session = session,
        lastSignIn = convertTimestampToDate(time)
    )

    private fun convertTimestampToDate(timestamp: Long): String {
        val date = Date(timestamp)
        val formatPattern = "dd.MM.yyyy, HH:mm"
        val sdf = SimpleDateFormat(formatPattern, Locale.getDefault())
        return sdf.format(date)
    }

    companion object {

        const val NAME = "account"

        fun fromAccount(account: Account) = AccountDbEntity(
            id = account.id,
            domain = account.domain,
            login = account.login,
            company = account.company,
            contact = account.contact,
            session = account.session,
            time = getTimestamp()
        )

        private fun getTimestamp(): Long {
            return Date().time
        }
    }
}