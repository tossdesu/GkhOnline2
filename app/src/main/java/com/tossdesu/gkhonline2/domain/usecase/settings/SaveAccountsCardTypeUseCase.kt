package com.tossdesu.gkhonline2.domain.usecase.settings

import com.tossdesu.gkhonline2.domain.SettingsRepository

class SaveAccountsCardTypeUseCase(
    private val repository: SettingsRepository
) {

    suspend operator fun invoke(type: Int) {
        repository.saveAccountsCardType(type)
    }
}