package com.example.lifehacktesttask.screens.list_screen.di

import com.example.lifehacktesttask.screens.list_screen.repository.interfaces.CompaniesListLoader
import com.example.lifehacktesttask.screens.list_screen.domain.GetAdapterUseCaseImpl
import com.example.lifehacktesttask.screens.list_screen.viewmodel.interfaces.GetAdapterUseCase
import dagger.Module
import dagger.Provides

@Module
class ListScreenDomainModule {

    @Provides
    fun provideGetAdapterUseCase(companiesListLoader: CompaniesListLoader): GetAdapterUseCase =
        GetAdapterUseCaseImpl(companiesListLoader)
}