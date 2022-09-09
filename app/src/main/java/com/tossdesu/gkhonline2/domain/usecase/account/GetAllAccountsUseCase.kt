package com.tossdesu.gkhonline2.domain.usecase.account

import com.tossdesu.gkhonline2.domain.AccountRepository
import com.tossdesu.gkhonline2.domain.entity.Account

class GetAllAccountsUseCase(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(): List<Account> {
        return repository.getAllAccounts()
    }
}