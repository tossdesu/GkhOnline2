package com.tossdesu.gkhonline2.domain.usecase.settings

import com.tossdesu.gkhonline2.domain.SettingsRepository

class SavePushTokenUseCase(
    private val repository: SettingsRepository
) {

    suspend operator fun invoke(token: String) {
        repository.savePushToken(token)
    }
}