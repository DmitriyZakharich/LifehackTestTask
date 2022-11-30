package com.example.lifehacktesttask.screens.details_screen.domain.model

import com.squareup.picasso.RequestCreator

/**
 * Ответ приходит в виде ArrayList<CompanyInfo>
 */
data class CompanyInfoDomain(
        val description: String,
        val id: String,
        val img: RequestCreator,
        val lat: Double,
        val lon: Double,
        val name: String,
        val phone: String,
        val www: String
)