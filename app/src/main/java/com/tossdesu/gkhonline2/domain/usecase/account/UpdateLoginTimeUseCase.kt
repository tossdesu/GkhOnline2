package com.tossdesu.gkhonline2.domain.usecase.account

import com.tossdesu.gkhonline2.domain.AccountRepository
import javax.inject.Inject

class UpdateLoginTimeUseCase @Inject constructor(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(id: Long, time: Long) {
        return repository.updateLoginTime(id, time)
    }
}