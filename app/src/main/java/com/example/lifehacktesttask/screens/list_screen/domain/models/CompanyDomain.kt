package com.example.lifehacktesttask.screens.list_screen.domain.models

import com.squareup.picasso.RequestCreator

data class CompanyDomain(
        val id: String,
        val img: RequestCreator,
        val name: String
)