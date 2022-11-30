package com.example.lifehacktesttask.screens.details_screen.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.lifehacktesttask.screens.details_screen.domain.interfaces.GetDataUseCase
import com.example.lifehacktesttask.screens.details_screen.domain.mappers.modelRepositoryToDomain
import com.example.lifehacktesttask.screens.details_screen.domain.model.CompanyInfoDomain
import com.example.lifehacktesttask.screens.details_screen.repository.interfaces.CompanyInfoLoader
import com.example.lifehacktesttask.screens.details_screen.repository.model.CompanyInfoRepository

class GetDataUseCaseImpl(private val companyInfoLoader: CompanyInfoLoader) : GetDataUseCase {

    private val _info = MutableLiveData<CompanyInfoDomain>()
    override val info: LiveData<CompanyInfoDomain> = _info

    init {
        companyInfoLoader.info.observeForever(observerNetwork())
    }

    private fun observerNetwork() =
        Observer<CompanyInfoRepository> {
            _info.value = modelRepositoryToDomain(it)
        }

    override fun start(id: String) {
        companyInfoLoader.start(id = id)
    }
}