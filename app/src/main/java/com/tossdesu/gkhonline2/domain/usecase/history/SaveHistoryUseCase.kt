package com.tossdesu.gkhonline2.domain.usecase.history

import com.tossdesu.gkhonline2.domain.AccountRepository
import com.tossdesu.gkhonline2.domain.entity.HistorySave
import javax.inject.Inject

class SaveHistoryUseCase @Inject constructor(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(history: List<HistorySave>) {
        repository.saveHistory(history)
    }
}