package com.tossdesu.gkhonline2.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tossdesu.gkhonline2.data.database.entity.AccountDbEntity
import com.tossdesu.gkhonline2.data.database.entity.SettingsDbEntity
import com.tossdesu.gkhonline2.data.database.entity.HistoryDbEntity
import com.tossdesu.gkhonline2.data.database.entity.MenuItemsDbEntity

@Database(
    entities = [
        AccountDbEntity::class,
        SettingsDbEntity::class,
        HistoryDbEntity::class,
        MenuItemsDbEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun accountDao(): AccountDao

    abstract fun settingsDao(): SettingsDao

    companion object {

        private const val DB_NAME = "gkh_online.db"
        private var INSTANCE: AppDatabase? = null
        private val LOCK = Any()

        fun getInstance(application: Application): AppDatabase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application,
                    AppDatabase::class.java,
                    DB_NAME
                ).build()
                INSTANCE = db
                return db
            }
        }
    }
}