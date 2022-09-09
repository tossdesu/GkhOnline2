package com.tossdesu.gkhonline2.data.database.entity

import androidx.room.*
import com.tossdesu.gkhonline2.data.database.entity.MenuItemsDbEntity.Companion.NAME
import com.tossdesu.gkhonline2.domain.entity.MenuItem

@Entity(
    tableName = NAME,
    indices = [
        Index("account_id", unique = false)
    ],
    foreignKeys = [
        ForeignKey(
            entity = AccountDbEntity::class,
            parentColumns = ["id"],
            childColumns = ["account_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class MenuItemsDbEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val url: String,
    val title: String,
    val icon: String,
    @ColumnInfo(name = "account_id")
    val accountId: Long
) {

    fun toMenuItem() = MenuItem(
        url = url,
        title = title,
        icon = icon,
        accountId = accountId
    )

    companion object {

        const val NAME = "menu_items"

        fun fromMenuItem(menuItem: MenuItem) = MenuItemsDbEntity(
            id = 0,
            url = menuItem.url,
            title = menuItem.title,
            icon = menuItem.icon,
            accountId = menuItem.accountId
        )
    }
}