package com.example.bootcounter.data.data_store.local

import com.example.bootcounter.data.data_store.local.room.RoomModule
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [RoomModule::class])
@InstallIn(SingletonComponent::class)
interface LocalDataStoreModule {
    @Binds
    fun bindDataStore(dataStore: LocalDataStoreImpl): LocalDataStore
}