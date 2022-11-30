package com.example.lifehacktesttask.screens.details_screen.repository.interfaces

import androidx.lifecycle.LiveData
import com.example.lifehacktesttask.screens.details_screen.domain.model.CompanyInfo

interface CompanyInfoLoader {
    val info: LiveData<CompanyInfo>
    fun start(id: String)
}