package com.example.lifehacktesttask.screens.list_screen.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.lifehacktesttask.screens.list_screen.domain.mappers.modelRepositoryToDomain
import com.example.lifehacktesttask.screens.list_screen.repository.interfaces.CompaniesListLoader
import com.example.lifehacktesttask.screens.list_screen.repository.models.CompanyRepository
import com.example.lifehacktesttask.screens.list_screen.viewmodel.interfaces.GetAdapterUseCase

class GetAdapterUseCaseImpl(private val companiesListLoader: CompaniesListLoader) : GetAdapterUseCase {

    private var _adapter: MutableLiveData<CustomRecyclerAdapter> = MutableLiveData()
    override var adapter: LiveData<CustomRecyclerAdapter> = _adapter

    init {
        companiesListLoader.companiesList.observeForever(observer())
    }

    private fun observer() = Observer<List<CompanyRepository>> { list ->
        _adapter.value = CustomRecyclerAdapter(data = modelRepositoryToDomain(list))
    }

    override fun start() {
        companiesListLoader.loadGithubReposList()
    }
}
