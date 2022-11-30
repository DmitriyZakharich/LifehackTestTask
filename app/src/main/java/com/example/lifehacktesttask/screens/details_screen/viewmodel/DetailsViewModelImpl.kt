package com.example.lifehacktesttask.screens.details_screen.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lifehacktesttask.screens.details_screen.domain.interfaces.GetDataUseCase
import com.example.lifehacktesttask.screens.details_screen.domain.model.CompanyInfoDomain
import com.example.lifehacktesttask.screens.details_screen.presentation.interfaces.DetailsViewModel

class DetailsViewModelImpl(private val getDataUseCase: GetDataUseCase) : ViewModel(),
    DetailsViewModel {

    private var _info = MutableLiveData<CompanyInfoDomain>()
    override val info: LiveData<CompanyInfoDomain> = _info

    override fun getData(id: String) {
        getDataUseCase.info.observeForever {
            _info.value = it
        }
        getDataUseCase.start(id = id)
    }
}