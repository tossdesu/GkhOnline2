package com.tossdesu.gkhonline2.domain.usecase.account

import com.tossdesu.gkhonline2.domain.AccountRepository
import com.tossdesu.gkhonline2.domain.entity.AccountInExplorer
import javax.inject.Inject

class GetAccountUseCase @Inject constructor(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(accountId: Long): AccountInExplorer {
        return repository.getAccount(accountId)
    }
}