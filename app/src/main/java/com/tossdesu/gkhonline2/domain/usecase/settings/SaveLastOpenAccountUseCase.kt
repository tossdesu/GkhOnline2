package com.tossdesu.gkhonline2.domain.usecase.settings

import com.tossdesu.gkhonline2.domain.SettingsRepository

class SaveLastOpenAccountUseCase(
    private val repository: SettingsRepository
) {

    suspend operator fun invoke(accountId: Long) {
        repository.saveLastOpenAccount(accountId)
    }
}