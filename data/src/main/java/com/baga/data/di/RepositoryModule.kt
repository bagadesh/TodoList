package com.baga.data.di

import com.baga.data.repository.ProjectRepositoryImpl
import com.baga.domain.repository.ProjectRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by bagadesh on 04/03/23.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindProjectRepositoryImpl(projectRepositoryImpl: ProjectRepositoryImpl): ProjectRepository
}