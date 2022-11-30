package com.example.lifehacktesttask.screens.list_screen.di

import com.example.lifehacktesttask.screens.list_screen.presentation.ListFragment
import dagger.Component

@Component(modules = [ListScreenModule::class, ListScreenDomainModule::class, RepositoryModule::class])
interface ListScreenComponent {
    fun inject(listFragment: ListFragment)
}