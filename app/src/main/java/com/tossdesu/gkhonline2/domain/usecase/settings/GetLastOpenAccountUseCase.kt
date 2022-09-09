package com.tossdesu.gkhonline2.domain.usecase.settings

import com.tossdesu.gkhonline2.domain.SettingsRepository

class GetLastOpenAccountUseCase(
    private val repository: SettingsRepository
) {

    suspend operator fun invoke(): Long {
        return repository.getLastOpenAccount()
    }
}