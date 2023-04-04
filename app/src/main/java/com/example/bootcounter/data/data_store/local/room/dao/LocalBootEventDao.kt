package com.example.bootcounter.data.data_store.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bootcounter.data.data_store.local.room.entity.LocalBootEvent
import kotlinx.coroutines.flow.Flow

@Dao
interface LocalBootEventDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(event: LocalBootEvent)

    @Query("SELECT * FROM boot_event")
    fun subscribe(): Flow<List<LocalBootEvent>>

    @Query("SELECT COUNT(timestamp) FROM boot_event")
    fun count(): Int
}