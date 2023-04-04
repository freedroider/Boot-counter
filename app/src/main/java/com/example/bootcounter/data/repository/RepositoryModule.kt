package com.example.bootcounter.data.repository

import com.example.bootcounter.domain.repository.BootRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindBootRepository(repository: BootRepositoryImpl): BootRepository
}