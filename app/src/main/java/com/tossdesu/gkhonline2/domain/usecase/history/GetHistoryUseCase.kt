package com.tossdesu.gkhonline2.domain.usecase.history

import com.tossdesu.gkhonline2.domain.AccountRepository
import com.tossdesu.gkhonline2.domain.entity.History
import javax.inject.Inject

class GetHistoryUseCase @Inject constructor(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(accountId: Long): List<History> {
        return repository.getHistory(accountId)
    }
}