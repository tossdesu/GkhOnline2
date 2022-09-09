package com.tossdesu.gkhonline2.domain.usecase.account

import com.tossdesu.gkhonline2.domain.AccountRepository
import com.tossdesu.gkhonline2.domain.entity.Account

class AddAccountUseCase(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(account: Account) {
        repository.addAccount(account)
    }
}