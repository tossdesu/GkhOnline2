package com.tossdesu.gkhonline2.domain.usecase.account

import com.tossdesu.gkhonline2.domain.AccountRepository
import com.tossdesu.gkhonline2.domain.entity.AccountExists

class FindByDomainAndLoginUseCase(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(domain: String, login: String): AccountExists? {
        return repository.findByDomainAndLogin(domain, login)
    }
}