package com.example.soriginassignment.di.module

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MovieViewModule(get(),get())
    }
}