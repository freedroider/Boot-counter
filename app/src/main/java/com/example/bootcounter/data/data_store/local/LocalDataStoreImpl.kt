package com.example.bootcounter.data.data_store.local

import com.example.bootcounter.data.data_store.local.room.AppDatabase
import com.example.bootcounter.data.data_store.local.room.entity.LocalBootEvent
import com.example.bootcounter.data.data_store.local.room.entity.asBootEvent
import com.example.bootcounter.data.data_store.local.room.entity.asLocalBootEvent
import com.example.bootcounter.domain.entity.BootEvent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalDataStoreImpl @Inject constructor(
    private val database: AppDatabase
) : LocalDataStore {
    override suspend fun saveBootEvent(event: BootEvent) {
        database.bootEventDao()
            .insert(event.asLocalBootEvent())
    }

    override fun subscribeOnBootEvents(): Flow<List<BootEvent>> {
        return database.bootEventDao()
            .subscribe()
            .map { events -> events.map { event -> event.asBootEvent() } }
    }

    override suspend fun bootEventsCount(): Int {
        return database.bootEventDao()
            .count()
    }
}