package com.example.lifehacktesttask.screens.details_screen.presentation.interfaces

import androidx.lifecycle.LiveData
import com.example.lifehacktesttask.screens.details_screen.domain.model.CompanyInfo

interface DetailsViewModel {
    val info: LiveData<CompanyInfo>
    fun getData(id: String)
}