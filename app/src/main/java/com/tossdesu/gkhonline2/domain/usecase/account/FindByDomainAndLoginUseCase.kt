package com.tossdesu.gkhonline2.domain.usecase.account

import com.tossdesu.gkhonline2.domain.AccountRepository
import com.tossdesu.gkhonline2.domain.entity.AccountExists
import javax.inject.Inject

class FindByDomainAndLoginUseCase @Inject constructor(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(domain: String, login: String): AccountExists? {
        return repository.findByDomainAndLogin(domain, login)
    }
}