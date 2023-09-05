package com.example.carwashmap.domain

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.carwashmap.models.EntryModel
import com.example.carwashmap.models.ServiceWorkModel
import kotlinx.coroutines.CoroutineScope


@Database(entities = [ServiceWorkModel::class, EntryModel::class], version = 1)
abstract class ServiceDatabase : RoomDatabase() {

    abstract fun servicesDao(): ServicesDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: ServiceDatabase? = null

        fun getDatabase(context: Context,
                        scope: CoroutineScope
        ): ServiceDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ServiceDatabase::class.java,
                    "word_database"
                )
                    .createFromAsset("database/main_db.db")
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}