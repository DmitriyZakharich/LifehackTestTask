package com.example.lifehacktesttask.screens.details_screen.di

import com.example.lifehacktesttask.screens.details_screen.repository.interfaces.CompanyInfoLoader
import com.example.lifehacktesttask.screens.details_screen.repository.network.CompanyInfoLoaderImpl
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun provideCompanyInfoLoader(): CompanyInfoLoader = CompanyInfoLoaderImpl()
}