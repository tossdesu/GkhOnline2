package com.tossdesu.gkhonline2.domain.usecase.account

import com.tossdesu.gkhonline2.domain.AccountRepository

class GetDomainsOfOpenAccountsUseCase(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(): List<String> {
        return repository.getDomainsOfOpenAccounts()
    }
}