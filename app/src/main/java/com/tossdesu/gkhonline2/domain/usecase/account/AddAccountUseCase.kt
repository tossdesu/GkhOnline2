package com.tossdesu.gkhonline2.domain.usecase.account

import com.tossdesu.gkhonline2.domain.AccountRepository
import com.tossdesu.gkhonline2.domain.entity.Account
import javax.inject.Inject

class AddAccountUseCase @Inject constructor(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(account: Account) {
        repository.addAccount(account)
    }
}