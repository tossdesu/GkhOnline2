package com.tossdesu.gkhonline2.domain.usecase.history

import com.tossdesu.gkhonline2.domain.AccountRepository
import com.tossdesu.gkhonline2.domain.entity.HistorySave

class SaveHistoryUseCase(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(history: List<HistorySave>) {
        repository.saveHistory(history)
    }
}