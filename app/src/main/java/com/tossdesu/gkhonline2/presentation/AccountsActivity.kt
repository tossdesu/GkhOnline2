package com.tossdesu.gkhonline2.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.tossdesu.gkhonline2.R
import javax.inject.Inject

class AccountsActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[AccountsViewModel::class.java]
    }

    private val appComponent by lazy {
        (application as GkhOnlineApp).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accounts)

        viewModel.signIn("login", "password")
    }
}