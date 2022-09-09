package com.tossdesu.gkhonline2.domain.usecase.account

import com.tossdesu.gkhonline2.domain.AccountRepository
import com.tossdesu.gkhonline2.domain.entity.AccountInExplorer

class GetAccountUseCase(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(accountId: Long): AccountInExplorer {
        return repository.getAccount(accountId)
    }
}