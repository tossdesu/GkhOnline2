package com.tossdesu.gkhonline2.domain.usecase.menu

import com.tossdesu.gkhonline2.domain.AccountRepository
import javax.inject.Inject

class DeleteMenuUseCase @Inject constructor(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(accountId: Long) {
        repository.deleteMenu(accountId)
    }
}