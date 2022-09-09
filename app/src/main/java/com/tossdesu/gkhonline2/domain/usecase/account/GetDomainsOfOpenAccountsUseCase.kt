package com.tossdesu.gkhonline2.domain.usecase.account

import com.tossdesu.gkhonline2.domain.AccountRepository
import javax.inject.Inject

class GetDomainsOfOpenAccountsUseCase @Inject constructor(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(): List<String> {
        return repository.getDomainsOfOpenAccounts()
    }
}