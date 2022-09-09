package com.tossdesu.gkhonline2.di

import android.app.Application
import com.tossdesu.gkhonline2.data.AccountRepositoryImpl
import com.tossdesu.gkhonline2.data.SettingsRepositoryImpl
import com.tossdesu.gkhonline2.data.database.AccountDao
import com.tossdesu.gkhonline2.data.database.AppDatabase
import com.tossdesu.gkhonline2.data.database.SettingsDao
import com.tossdesu.gkhonline2.data.network.ApiFactory
import com.tossdesu.gkhonline2.data.network.ApiService
import com.tossdesu.gkhonline2.domain.AccountRepository
import com.tossdesu.gkhonline2.domain.SettingsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindAccountRepositoryImpl(impl: AccountRepositoryImpl): AccountRepository

    @Binds
    @ApplicationScope
    fun bindSettingsRepositoryImpl(impl: SettingsRepositoryImpl): SettingsRepository

    companion object {

        @Provides
        @ApplicationScope
        fun provideAccountDao(
            application: Application
        ): AccountDao {
            return AppDatabase.getInstance(application).accountDao()
        }

        @Provides
        @ApplicationScope
        fun provideSettingsDao(
            application: Application
        ): SettingsDao {
            return AppDatabase.getInstance(application).settingsDao()
        }

        @Provides
        @ApplicationScope
        fun provideApiService():ApiService {
            return ApiFactory.apiService
        }
    }
}