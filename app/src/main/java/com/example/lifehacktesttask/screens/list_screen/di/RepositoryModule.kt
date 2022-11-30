package com.example.lifehacktesttask.screens.list_screen.di

import com.example.lifehacktesttask.screens.list_screen.repository.interfaces.CompaniesListLoader
import com.example.lifehacktesttask.screens.list_screen.repository.network.CompaniesListLoaderImpl
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun provideCompaniesListLoader(): CompaniesListLoader = CompaniesListLoaderImpl()
}