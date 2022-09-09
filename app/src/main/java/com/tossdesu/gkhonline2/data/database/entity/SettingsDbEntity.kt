package com.tossdesu.gkhonline2.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tossdesu.gkhonline2.data.database.entity.SettingsDbEntity.Companion.NAME

@Entity(tableName = NAME)
data class SettingsDbEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "device_id")
    val deviceId: String,
    @ColumnInfo(name = "push_token_id")
    val pushTokenId: String,
    @ColumnInfo(name = "push_service_type")
    val pushServiceType: String,
    @ColumnInfo(name = "last_open_account")
    val LastOpenAccount: Long,
    @ColumnInfo(name = "accounts_card_type")
    val accountsCardType: Int
) {

    companion object {

        const val NAME = "app_settings"
    }
}