package com.example.bootcounter.data.data_store.local.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.bootcounter.domain.entity.BootEvent

@Entity(tableName = "boot_event")
data class LocalBootEvent(
    @PrimaryKey
    @ColumnInfo(name = "timestamp")
    val timestamp: Long
)

fun LocalBootEvent.asBootEvent(): BootEvent {
    return BootEvent(timestamp = timestamp)
}

fun BootEvent.asLocalBootEvent(): LocalBootEvent {
    return LocalBootEvent(timestamp = timestamp)
}