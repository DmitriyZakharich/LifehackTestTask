package com.example.lifehacktesttask.screens.details_screen.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.lifehacktesttask.screens.details_screen.domain.interfaces.GetDataUseCase
import com.example.lifehacktesttask.screens.details_screen.domain.model.CompanyInfo
import com.example.lifehacktesttask.screens.details_screen.repository.interfaces.CompanyInfoLoader

class GetDataUseCaseImpl(private val companyInfoLoader: CompanyInfoLoader) : GetDataUseCase {

    private val _info = MutableLiveData<CompanyInfo>()
    override val info: LiveData<CompanyInfo> = _info

    init {
        companyInfoLoader.info.observeForever(observerNetwork())
    }

    private fun observerNetwork() =
        Observer<CompanyInfo> {
            _info.value = it
        }

    override fun start(id: String) {
        companyInfoLoader.start(id = id)
    }
}