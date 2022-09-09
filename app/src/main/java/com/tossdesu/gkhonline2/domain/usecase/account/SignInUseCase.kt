package com.tossdesu.gkhonline2.domain.usecase.account

import com.tossdesu.gkhonline2.domain.AccountRepository

class SignInUseCase(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(login: String, password: String, device_id: String) {
        repository.signIn(login, password, device_id)
    }
}