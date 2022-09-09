package com.tossdesu.gkhonline2.domain.usecase.account

import com.tossdesu.gkhonline2.domain.AccountRepository

class UpdateLoginTimeUseCase(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(id: Long, time: Long) {
        return repository.updateLoginTime(id, time)
    }
}