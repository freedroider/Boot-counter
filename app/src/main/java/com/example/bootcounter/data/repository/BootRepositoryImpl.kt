package com.example.bootcounter.data.repository

import com.example.bootcounter.data.data_store.local.LocalDataStore
import com.example.bootcounter.domain.entity.BootEvent
import com.example.bootcounter.domain.repository.BootRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BootRepositoryImpl @Inject constructor(
    private val localDataStore: LocalDataStore
) : BootRepository {
    override suspend fun save(event: BootEvent) {
        localDataStore.saveBootEvent(event)
    }

    override fun subscribe(): Flow<List<BootEvent>> {
        return localDataStore.subscribeOnBootEvents()
    }

    override suspend fun count(): Int = localDataStore.bootEventsCount()
}