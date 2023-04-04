package com.example.bootcounter.domain.repository

import com.example.bootcounter.domain.entity.BootEvent
import kotlinx.coroutines.flow.Flow

interface BootRepository {
    suspend fun save(event: BootEvent)

    fun subscribe(): Flow<List<BootEvent>>

    suspend fun count(): Int
}