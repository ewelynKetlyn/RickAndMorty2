package com.example.rickandmorty2.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RickAndMortyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RickAndMortyApplication)
            modules(listOf(networkModule, domainModule, dataModule, presentationModule))
        }
    }
}