package com.example.lifehacktesttask.screens.details_screen.domain.model

/**
 * Ответ приходит в виде ArrayList<CompanyInfo>
 */
data class CompanyInfo(
        val description: String,
        val id: String,
        val img: String,
        val lat: Double,
        val lon: Double,
        val name: String,
        val phone: String,
        val www: String
)