package com.tossdesu.gkhonline2.domain.usecase.settings

import com.tossdesu.gkhonline2.domain.SettingsRepository
import javax.inject.Inject

class SavePushTokenUseCase @Inject constructor(
    private val repository: SettingsRepository
) {

    suspend operator fun invoke(token: String) {
        repository.savePushToken(token)
    }
}