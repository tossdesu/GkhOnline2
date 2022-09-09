package com.tossdesu.gkhonline2.domain.usecase.settings

import com.tossdesu.gkhonline2.domain.SettingsRepository
import javax.inject.Inject

class GetAccountsCardTypeUseCase @Inject constructor(
    private val repository: SettingsRepository
) {

    suspend operator fun invoke(): Int {
        return repository.getAccountsCardType()
    }
}