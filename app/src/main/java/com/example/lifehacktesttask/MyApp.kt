package com.example.lifehacktesttask

import android.app.Application
import android.content.Context
import com.example.lifehacktesttask.screens.details_screen.di.DaggerDetailsScreenComponent
import com.example.lifehacktesttask.screens.details_screen.di.DetailsScreenComponent
import com.example.lifehacktesttask.screens.list_screen.di.DaggerListScreenComponent
import com.example.lifehacktesttask.screens.list_screen.di.ListScreenComponent

class MyApp : Application() {

    lateinit var listScreenComponent: ListScreenComponent
    lateinit var detailsScreenComponent: DetailsScreenComponent

    init {
        instance = this
    }

    companion object {
        private var instance: MyApp? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        listScreenComponent = DaggerListScreenComponent.builder().build()
        detailsScreenComponent = DaggerDetailsScreenComponent.builder().build()
    }
}