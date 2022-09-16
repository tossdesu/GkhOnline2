package com.tossdesu.gkhonline2.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.tossdesu.gkhonline2.domain.entity.Account

class AccountDiffCallback : DiffUtil.ItemCallback<Account>() {

    override fun areItemsTheSame(oldItem: Account, newItem: Account): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Account, newItem: Account): Boolean {
        return oldItem == newItem
    }
}