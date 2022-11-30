package com.example.lifehacktesttask.screens.details_screen.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lifehacktesttask.screens.details_screen.domain.interfaces.GetDataUseCase
import com.example.lifehacktesttask.screens.details_screen.domain.model.CompanyInfo
import com.example.lifehacktesttask.screens.details_screen.presentation.interfaces.DetailsViewModel

class DetailsViewModelImpl(private val getDataUseCase: GetDataUseCase) : ViewModel(),
    DetailsViewModel {

    private var _info = MutableLiveData<CompanyInfo>()
    override val info: LiveData<CompanyInfo> = _info

    override fun getData(id: String) {
        getDataUseCase.info.observeForever {
            _info.value = it
        }
        getDataUseCase.start(id = id)
    }
}