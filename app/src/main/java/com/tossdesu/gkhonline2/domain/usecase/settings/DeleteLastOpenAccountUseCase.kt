package com.tossdesu.gkhonline2.domain.usecase.settings

import com.tossdesu.gkhonline2.domain.SettingsRepository

class DeleteLastOpenAccountUseCase(
    private val repository: SettingsRepository
) {

    suspend operator fun invoke() {
        repository.deleteLastOpenAccount()
    }
}