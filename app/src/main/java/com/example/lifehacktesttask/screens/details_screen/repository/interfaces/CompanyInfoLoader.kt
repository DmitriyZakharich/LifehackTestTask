package com.example.lifehacktesttask.screens.details_screen.repository.interfaces

import androidx.lifecycle.LiveData
import com.example.lifehacktesttask.screens.details_screen.repository.model.CompanyInfoRepository

interface CompanyInfoLoader {
    val info: LiveData<CompanyInfoRepository>
    fun start(id: String)
}