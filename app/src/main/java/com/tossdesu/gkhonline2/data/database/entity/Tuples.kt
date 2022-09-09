package com.tossdesu.gkhonline2.data.database.entity

import com.tossdesu.gkhonline2.domain.entity.AccountExists
import com.tossdesu.gkhonline2.domain.entity.AccountInExplorer
import com.tossdesu.gkhonline2.domain.entity.AccountUpdate

data class AccountInExplorerTuple(
    val domain: String,
    val login: String,
    val company: String,
    val contact: String,
    val session: String
) {

    fun toAccountInExplorer() = AccountInExplorer(
        domain = domain,
        login = login,
        company = company,
        contact = contact,
        session = session
    )
}

data class AccountExistsTuple(
    val id: Long,
    val session: String
) {

    fun toAccountExists() = AccountExists(
        id = id,
        session = session
    )
}

data class AccountUpdateTuple(
    val id: Long,
    val company: String,
    val contact: String,
    val session: String,
    val time: Long
) {

    companion object {

        fun fromAccountUpdate(account: AccountUpdate) = AccountUpdateTuple(
            id = account.id,
            company = account.company,
            contact = account.contact,
            session = account.session,
            time = account.time
        )
    }
}

data class AccountUpdateLoginTimeTuple(
    val id: Long,
    val time: Long
)