package com.example.lifehacktesttask.screens.details_screen.presentation.interfaces

import androidx.lifecycle.LiveData
import com.example.lifehacktesttask.screens.details_screen.domain.model.CompanyInfoDomain

interface DetailsViewModel {
    val info: LiveData<CompanyInfoDomain>
    fun getData(id: String)
}