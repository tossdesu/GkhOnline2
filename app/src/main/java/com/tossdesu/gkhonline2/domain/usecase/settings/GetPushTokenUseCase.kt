package com.tossdesu.gkhonline2.domain.usecase.settings

import com.tossdesu.gkhonline2.domain.SettingsRepository

class GetPushTokenUseCase(
    private val repository: SettingsRepository
) {

    suspend operator fun invoke(): String {
        return repository.getPushToken()
    }
}