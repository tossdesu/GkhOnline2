package com.tossdesu.gkhonline2.domain.usecase.history

import com.tossdesu.gkhonline2.domain.AccountRepository
import javax.inject.Inject

class DeleteHistoryUseCase @Inject constructor(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(accountId: Long) {
        repository.deleteHistory(accountId)
    }
}