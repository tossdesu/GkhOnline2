package com.tossdesu.gkhonline2.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tossdesu.gkhonline2.R
import com.tossdesu.gkhonline2.databinding.ItemAccountBinding
import com.tossdesu.gkhonline2.databinding.ItemAccountFooterBinding
import com.tossdesu.gkhonline2.domain.entity.Account

class AccountsAdapter : ListAdapter<Account, RecyclerView.ViewHolder>(AccountDiffCallback()) {

    var setOnAccountClickListener: ((Account) -> Unit)? = null
    var setOnAccountAddClickListener: (() -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            VIEW_TYPE_ACCOUNT -> {
                val binding = ItemAccountBinding.inflate(LayoutInflater.from(parent.context))
                AccountHolder(binding)
            }
            VIEW_TYPE_FOOTER -> {
                val binding = ItemAccountFooterBinding.inflate(LayoutInflater.from(parent.context))
                FooterHolder(binding)
            }
            else -> throw RuntimeException("Unknown view type: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(holder.adapterPosition)
        when(holder) {
            is AccountHolder -> {
                with(holder.binding) {
                    tvCompany.text = item.company
                    tvContact.text = item.contact
                    val statusIconResId =
                        if (item.isSignIn) R.drawable.ic_active_account
                        else R.drawable.ic_not_auth_account
                    ivSignInStatus.setImageResource(statusIconResId)
                    tvSignInTime.text = item.lastSignIn
                    root.setOnClickListener {
                        setOnAccountClickListener?.invoke(getItem(holder.layoutPosition))
                    }
                }
            }
            is FooterHolder -> {
                holder.binding.root.setOnClickListener {
                    setOnAccountAddClickListener?.invoke()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return currentList.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position != itemCount)  VIEW_TYPE_ACCOUNT else VIEW_TYPE_FOOTER
    }

    companion object {

        const val VIEW_TYPE_ACCOUNT = 1
        const val VIEW_TYPE_FOOTER = 2
    }
}