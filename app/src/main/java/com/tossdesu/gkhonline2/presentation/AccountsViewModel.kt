package com.tossdesu.gkhonline2.presentation

import android.os.Build
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tossdesu.gkhonline2.domain.usecase.account.GetAllAccountsUseCase
import com.tossdesu.gkhonline2.domain.usecase.account.SignInUseCase
import com.tossdesu.gkhonline2.domain.usecase.settings.GeDeviceIdUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class AccountsViewModel @Inject constructor(
    private val getAllAccountsUseCase: GetAllAccountsUseCase,
    private val geDeviceIdUseCase: GeDeviceIdUseCase,
    private val signInUseCase: SignInUseCase
): ViewModel() {

    fun signIn(login: String, password: String) {
        viewModelScope.launch {
            val deviceId = geDeviceIdUseCase()
            signInUseCase(login, password, deviceId)
        }
    }
}