package com.example.zadatak

import org.koin.dsl.module

val appModule = module {
    single { NewsRepository() }
}