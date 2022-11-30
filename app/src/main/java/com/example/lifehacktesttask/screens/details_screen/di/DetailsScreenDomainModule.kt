package com.example.lifehacktesttask.screens.details_screen.di

import com.example.lifehacktesttask.screens.details_screen.domain.GetDataUseCaseImpl
import com.example.lifehacktesttask.screens.details_screen.domain.interfaces.GetDataUseCase
import com.example.lifehacktesttask.screens.details_screen.repository.interfaces.CompanyInfoLoader
import dagger.Module
import dagger.Provides

@Module
class DetailsScreenDomainModule {
    @Provides
    fun provideGetDataUseCase(companyInfoLoader: CompanyInfoLoader): GetDataUseCase =
        GetDataUseCaseImpl(companyInfoLoader)
}