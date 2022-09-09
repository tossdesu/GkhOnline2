package com.tossdesu.gkhonline2.domain.usecase.settings

import com.tossdesu.gkhonline2.domain.SettingsRepository
import javax.inject.Inject

class GetLastOpenAccountUseCase @Inject constructor(
    private val repository: SettingsRepository
) {

    suspend operator fun invoke(): Long {
        return repository.getLastOpenAccount()
    }
}