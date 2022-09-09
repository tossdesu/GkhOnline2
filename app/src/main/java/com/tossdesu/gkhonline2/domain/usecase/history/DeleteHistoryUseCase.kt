package com.tossdesu.gkhonline2.domain.usecase.history

import com.tossdesu.gkhonline2.domain.AccountRepository

class DeleteHistoryUseCase(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(accountId: Long) {
        repository.deleteHistory(accountId)
    }
}