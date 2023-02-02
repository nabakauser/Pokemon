package com.example.pokemon.di

import com.example.pokemon.MainViewModel
import com.example.pokemon.repository.PokemonRepository
import com.example.pokemon.RestHelper
import com.example.pokemon.utils.NetworkHelper
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ConfigurationClass {
    fun modules() = commonModule + repositoryModule + viewModelModule
}

val repositoryModule  = module {
    single { PokemonRepository(get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(get(),get()) }
}

val commonModule = module {
    single {
        NetworkHelper(androidContext())
    }
    single { RestHelper.client }
}

//why to create configuration class -> in case you don't create a conf. file , then you'll have to
//      create an object for every class every single time
//      also, you cannot create an object of an interface / abstract class