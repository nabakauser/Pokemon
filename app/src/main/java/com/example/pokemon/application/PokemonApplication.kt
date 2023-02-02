package com.example.pokemon.application

import android.app.Application
import com.example.pokemon.di.ConfigurationClass
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PokemonApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@PokemonApplication)
            modules(ConfigurationClass.modules())
        }
    }
}