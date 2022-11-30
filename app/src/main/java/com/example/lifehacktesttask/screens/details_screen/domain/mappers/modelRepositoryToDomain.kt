package com.example.lifehacktesttask.screens.details_screen.domain.mappers

import com.example.lifehacktesttask.screens.details_screen.domain.model.CompanyInfoDomain
import com.example.lifehacktesttask.screens.details_screen.repository.model.CompanyInfoRepository
import com.example.lifehacktesttask.utils.downloadImages

fun modelRepositoryToDomain(info: CompanyInfoRepository) =
    CompanyInfoDomain(
        description = info.description,
        id = info.id,
        img = downloadImages("https://lifehack.studio/test_task/${info.img}"),
        lat = info.lat,
        lon = info.lon,
        name = info.name,
        phone = info.phone,
        www = info.www)

