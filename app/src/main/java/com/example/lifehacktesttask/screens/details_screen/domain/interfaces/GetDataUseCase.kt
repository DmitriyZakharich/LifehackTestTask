package com.example.lifehacktesttask.screens.details_screen.domain.interfaces

import androidx.lifecycle.LiveData
import com.example.lifehacktesttask.screens.details_screen.domain.model.CompanyInfo

interface GetDataUseCase {
    val info: LiveData<CompanyInfo>
    fun start(id: String)
}