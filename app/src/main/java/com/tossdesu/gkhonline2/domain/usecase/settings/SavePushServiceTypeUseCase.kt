package com.tossdesu.gkhonline2.domain.usecase.settings

import com.tossdesu.gkhonline2.domain.SettingsRepository

class SavePushServiceTypeUseCase(
    private val repository: SettingsRepository
) {

    suspend operator fun invoke(type: String) {
        repository.savePushServiceType(type)
    }
}