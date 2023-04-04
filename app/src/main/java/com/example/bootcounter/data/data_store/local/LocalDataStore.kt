package com.example.bootcounter.data.data_store.local

import com.example.bootcounter.domain.entity.BootEvent
import kotlinx.coroutines.flow.Flow

interface LocalDataStore {
    suspend fun saveBootEvent(event: BootEvent)

    fun subscribeOnBootEvents(): Flow<List<BootEvent>>

    suspend fun bootEventsCount(): Int
}