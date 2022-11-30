package com.example.lifehacktesttask.screens.list_screen.repository.network

import com.example.lifehacktesttask.screens.list_screen.repository.models.CompanyRepository
import retrofit2.Call
import retrofit2.http.GET

interface RequestApiGithubRepos {
    @GET("test.php")
    fun getRequest(): Call<List<CompanyRepository>>
}