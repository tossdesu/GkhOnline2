package com.tossdesu.gkhonline2.presentation

import android.app.Application
import com.tossdesu.gkhonline2.di.DaggerApplicationComponent

class GkhOnlineApp: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory()
            .create(this)
    }
}