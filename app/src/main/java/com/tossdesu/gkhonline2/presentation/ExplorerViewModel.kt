package com.tossdesu.gkhonline2.presentation

import androidx.lifecycle.ViewModel
import com.tossdesu.gkhonline2.domain.usecase.account.GetAccountUseCase
import com.tossdesu.gkhonline2.domain.usecase.history.GetHistoryUseCase
import com.tossdesu.gkhonline2.domain.usecase.menu.GetMenuUseCase
import javax.inject.Inject

class ExplorerViewModel @Inject constructor(
    private val getAccountUseCase: GetAccountUseCase,
    private val getMenuUseCase: GetMenuUseCase,
    private val getHistoryUseCase: GetHistoryUseCase
): ViewModel() {

}