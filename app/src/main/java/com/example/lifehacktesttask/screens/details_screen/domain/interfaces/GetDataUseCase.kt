package com.example.lifehacktesttask.screens.details_screen.domain.interfaces

import androidx.lifecycle.LiveData
import com.example.lifehacktesttask.screens.details_screen.domain.model.CompanyInfoDomain

interface GetDataUseCase {
    val info: LiveData<CompanyInfoDomain>
    fun start(id: String)
}