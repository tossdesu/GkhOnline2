package com.tossdesu.gkhonline2.domain.usecase.menu

import com.tossdesu.gkhonline2.domain.AccountRepository
import com.tossdesu.gkhonline2.domain.entity.MenuItem

class GetMenuUseCase(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(accountId: Long): List<MenuItem> {
        return repository.getMenu(accountId)
    }
}