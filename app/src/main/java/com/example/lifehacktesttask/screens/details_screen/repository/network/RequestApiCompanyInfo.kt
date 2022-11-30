package com.example.lifehacktesttask.screens.details_screen.repository.network

import com.example.lifehacktesttask.screens.details_screen.repository.model.CompanyInfoRepository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RequestApiCompanyInfo {
    @GET("test.php")
    fun getRequest(@Query("id") id: String): Call<List<CompanyInfoRepository>>
}

