package com.example.lifehacktesttask.screens.list_screen.repository.network

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lifehacktesttask.MyApp
import com.example.lifehacktesttask.screens.list_screen.repository.interfaces.CompaniesListLoader
import com.example.lifehacktesttask.screens.list_screen.domain.models.CompanyDomain
import com.example.lifehacktesttask.screens.list_screen.repository.models.CompanyRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CompaniesListLoaderImpl : CompaniesListLoader {

    private val retrofit = Retrofit.Builder().baseUrl("https://lifehack.studio/test_task/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    private val _companiesList = MutableLiveData<List<CompanyRepository>>()
    override val companiesList: LiveData<List<CompanyRepository>> = _companiesList

    override fun loadGithubReposList() {
        val requestApiGithubRepos = retrofit.create(RequestApiGithubRepos::class.java)
        val call = requestApiGithubRepos.getRequest()

        call.enqueue(object : Callback<List<CompanyRepository>> {
            override fun onFailure(call: Call<List<CompanyRepository>>, t: Throwable) {
                Toast.makeText(MyApp.applicationContext(), "Нет данных", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<CompanyRepository>>,
                    response: Response<List<CompanyRepository>>) {
                _companiesList.value = response.body()
            }
        })
    }
}