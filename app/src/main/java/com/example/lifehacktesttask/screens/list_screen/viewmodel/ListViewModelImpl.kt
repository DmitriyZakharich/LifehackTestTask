package com.example.lifehacktesttask.screens.list_screen.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lifehacktesttask.screens.list_screen.domain.CustomRecyclerAdapter
import com.example.lifehacktesttask.screens.list_screen.viewmodel.interfaces.GetAdapterUseCase
import com.example.lifehacktesttask.screens.list_screen.presentation.interfaces.ListViewModel

class ListViewModelImpl(private val getAdapterUseCase: GetAdapterUseCase) : ViewModel(),
    ListViewModel {

    private var _adapter = MutableLiveData<CustomRecyclerAdapter>()
    override val adapter: LiveData<CustomRecyclerAdapter> = _adapter

    override fun getAdapter() {
        getAdapterUseCase.adapter.observeForever {
            _adapter.value = it
        }
        getAdapterUseCase.start()
    }
}