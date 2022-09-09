package com.tossdesu.gkhonline2.domain.usecase.account

import com.tossdesu.gkhonline2.domain.AccountRepository
import com.tossdesu.gkhonline2.domain.entity.AccountUpdate
import javax.inject.Inject

class UpdateAccountUseCase @Inject constructor(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(accountUpdate: AccountUpdate) {
        return repository.updateAccount(accountUpdate)
    }
}