package com.example.bootcounter.data.data_store.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bootcounter.data.data_store.local.room.dao.LocalBootEventDao
import com.example.bootcounter.data.data_store.local.room.entity.LocalBootEvent

@Database(
    entities = [
        LocalBootEvent::class,
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bootEventDao(): LocalBootEventDao
}