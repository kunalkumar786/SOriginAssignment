package com.example.soriginassignment.di.module

import com.example.soriginassignment.repository.MainRepository
import org.koin.dsl.module

val repoModule = module {
    single {
        MainRepository(get())
    }
}