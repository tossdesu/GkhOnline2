package com.tossdesu.gkhonline2.domain.usecase.settings

import com.tossdesu.gkhonline2.domain.SettingsRepository

class SaveAppInstallTimeUseCase(
    private val repository: SettingsRepository
) {

    suspend operator fun invoke(timeInMillis: String) {
        repository.saveAppInstallTime(timeInMillis)
    }
}