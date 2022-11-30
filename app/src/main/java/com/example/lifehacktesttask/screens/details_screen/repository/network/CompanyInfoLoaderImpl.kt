package com.example.lifehacktesttask.screens.details_screen.repository.network

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lifehacktesttask.MyApp
import com.example.lifehacktesttask.screens.details_screen.repository.interfaces.CompanyInfoLoader
import com.example.lifehacktesttask.screens.details_screen.repository.model.CompanyInfoRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CompanyInfoLoaderImpl : CompanyInfoLoader {

    private val retrofit = Retrofit.Builder().baseUrl("https://lifehack.studio/test_task/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    private val _info = MutableLiveData<CompanyInfoRepository>()
    override val info: LiveData<CompanyInfoRepository> = _info

    override fun start(id: String) {
        val requestApiGithubRepos = retrofit.create(RequestApiCompanyInfo::class.java)
        val call = requestApiGithubRepos.getRequest(id)

        call.enqueue(object : Callback<List<CompanyInfoRepository>> {
            override fun onFailure(call: Call<List<CompanyInfoRepository>>, t: Throwable) {
                Toast.makeText(MyApp.applicationContext(), "Нет данных", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<CompanyInfoRepository>>,
                    response: Response<List<CompanyInfoRepository>>) {
                if (response.isSuccessful) _info.value = response.body()?.get(0)    //Ответ приходит в виде List<CompanyInfo>, нужен только нулевой
            }
        })
    }
}