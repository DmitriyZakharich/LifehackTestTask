package com.example.lifehacktesttask.screens.list_screen.repository.interfaces

import androidx.lifecycle.LiveData
import com.example.lifehacktesttask.screens.list_screen.domain.models.CompanyDomain
import com.example.lifehacktesttask.screens.list_screen.repository.models.CompanyRepository

interface CompaniesListLoader {
    val companiesList: LiveData<List<CompanyRepository>>
    fun loadGithubReposList()
}