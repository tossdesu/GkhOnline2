package com.tossdesu.gkhonline2.domain.usecase.account

import com.tossdesu.gkhonline2.domain.AccountRepository

class ClearSessionUseCase(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(accountId: Long) {
        return repository.clearSession(accountId)
    }
}