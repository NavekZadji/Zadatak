package com.example.zadatak

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val activityModule = module {
    viewModel {
        NewsViewModel(newsRepository = get())
    }
}