package com.example.lifehacktesttask.screens.list_screen.domain.mappers

import com.example.lifehacktesttask.screens.list_screen.domain.models.CompanyDomain
import com.example.lifehacktesttask.screens.list_screen.repository.models.CompanyRepository
import com.example.lifehacktesttask.utils.downloadImages


fun modelRepositoryToDomain(
        list: List<CompanyRepository>): List<CompanyDomain> {
    val newList = mutableListOf<CompanyDomain>()

    list.forEach {
        newList.add(CompanyDomain(
            id = it.id,
            img = downloadImages("https://lifehack.studio/test_task/${it.img}"),
            name = it.name
        ))
    }
    return newList
}

