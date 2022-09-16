package com.tossdesu.gkhonline2.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.tossdesu.gkhonline2.R
import com.tossdesu.gkhonline2.databinding.ItemAccountBinding
import com.tossdesu.gkhonline2.domain.entity.Account

class AccountsAdapter : ListAdapter<Account, AccountHolder>(AccountDiffCallback()) {

    var setOnAccountClickListener: ((Account) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountHolder {
        val binding = ItemAccountBinding.inflate(LayoutInflater.from(parent.context))
        return AccountHolder(binding)
    }

    override fun onBindViewHolder(holder: AccountHolder, position: Int) {
        val item = getItem(holder.adapterPosition)
        with(holder.binding) {
            tvCompany.text = item.company
            tvContact.text = item.contact
            val statusIconResId =
                if (item.isSignIn) R.drawable.ic_active_account else R.drawable.ic_not_auth_account
            ivSignInStatus.setImageResource(statusIconResId)
            tvSignInTime.text = item.lastSignIn
            root.setOnClickListener {
                setOnAccountClickListener?.invoke(getItem(holder.layoutPosition))
            }
        }
    }
}