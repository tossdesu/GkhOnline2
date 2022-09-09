package com.tossdesu.gkhonline2.data.database.entity

import androidx.room.*
import com.tossdesu.gkhonline2.data.database.entity.HistoryDbEntity.Companion.NAME
import com.tossdesu.gkhonline2.domain.entity.History
import com.tossdesu.gkhonline2.domain.entity.HistorySave

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
data class HistoryDbEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val url: String,
    @ColumnInfo(name = "account_id")
    val accountId: Long
) {

    fun toHistory() = History(
        url = url
    )

    companion object {

        const val NAME = "history"

        fun fromHistorySave(history: HistorySave) = HistoryDbEntity(
            id = 0,
            url = history.url,
            accountId = history.accountId
        )
    }
}