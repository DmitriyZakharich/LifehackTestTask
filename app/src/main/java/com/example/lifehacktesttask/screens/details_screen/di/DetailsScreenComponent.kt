package com.example.lifehacktesttask.screens.details_screen.di

import com.example.lifehacktesttask.screens.details_screen.presentation.DetailsFragment
import dagger.Component

@Component(modules = [DetailsScreenModule::class, DetailsScreenDomainModule::class, RepositoryModule::class])
interface DetailsScreenComponent {
    fun inject(detailsFragment: DetailsFragment)
}