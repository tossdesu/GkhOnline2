package com.tossdesu.gkhonline2.di

import androidx.lifecycle.ViewModel
import com.tossdesu.gkhonline2.presentation.AccountsViewModel
import com.tossdesu.gkhonline2.presentation.ExplorerViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(AccountsViewModel::class)
    @Binds
    fun bindAccountsViewModel(viewModel: AccountsViewModel): ViewModel

    @IntoMap
    @ViewModelKey(ExplorerViewModel::class)
    @Binds
    fun bindExplorerViewModel(viewModel: ExplorerViewModel): ViewModel
}