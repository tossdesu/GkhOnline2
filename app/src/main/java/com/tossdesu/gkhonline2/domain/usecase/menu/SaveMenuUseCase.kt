package com.tossdesu.gkhonline2.domain.usecase.menu

import com.tossdesu.gkhonline2.domain.AccountRepository
import com.tossdesu.gkhonline2.domain.entity.MenuItem

class SaveMenuUseCase(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(menu: List<MenuItem>) {
        repository.saveMenu(menu)
    }
}