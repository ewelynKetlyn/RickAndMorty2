package com.example.rickandmorty2.di

import com.example.rickandmorty2.data.datasource.characterlist.CharacterListRemoteDataSource
import com.example.rickandmorty2.data.datasource.characterlist.CharacterListRemoteDataSourceImpl
import com.example.rickandmorty2.data.repository.CharacterListRepositoryImpl
import com.example.rickandmorty2.domain.repository.CharacterListRepository
import com.example.rickandmorty2.domain.usecase.GetCharacterListUseCase
import com.example.rickandmorty2.data.api.RetrofitService
import com.example.rickandmorty2.data.datasource.characterdetail.CharacterDetailRemoteDataSource
import com.example.rickandmorty2.data.datasource.characterdetail.CharacterDetailRemoteDataSourceImpl
import com.example.rickandmorty2.data.repository.CharacterDetailRepositoryImpl
import com.example.rickandmorty2.domain.repository.CharacterDetailRepository
import com.example.rickandmorty2.domain.usecase.GetCharacterDetailUseCase
import com.example.rickandmorty2.presentation.characterdetail.CharacterDetailViewModel
import com.example.rickandmorty2.presentation.characterlist.CharacterListViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

private const val BASE_URL = "https://rickandmortyapi.com/"

val networkModule = module {
    single<Gson> { GsonBuilder().create() }
    single {
        OkHttpClient.Builder()
            .build()
    }
    single<GsonConverterFactory> { GsonConverterFactory.create(get()) }
    single<RxJava2CallAdapterFactory> {
        RxJava2CallAdapterFactory.create()
    }
    single<Retrofit.Builder> {
        Retrofit.Builder()
            .client(get())
            .addConverterFactory(get<GsonConverterFactory>())
            .addCallAdapterFactory(get<RxJava2CallAdapterFactory>())
    }
    single<Retrofit> {
        get<Retrofit.Builder>()
            .baseUrl(BASE_URL)
            .build()
    }

    single<RetrofitService> {
        get<Retrofit>().create(RetrofitService::class.java)
    }
}

val domainModule = module {
    factory { GetCharacterListUseCase(get()) }
    factory { GetCharacterDetailUseCase(get()) }
}

val dataModule = module {
    factory<CharacterListRemoteDataSource> { CharacterListRemoteDataSourceImpl(get()) }
    factory<CharacterListRepository> { CharacterListRepositoryImpl(get()) }
    factory<CharacterDetailRemoteDataSource> { CharacterDetailRemoteDataSourceImpl(get()) }
    factory<CharacterDetailRepository> { CharacterDetailRepositoryImpl(get()) }
}

val presentationModule = module {
    viewModel {
        CharacterListViewModel(
            getCharacterListUseCase = get()
        )
    }
    viewModel {
        CharacterDetailViewModel(
            getCharacterDetailUseCase = get()
        )
    }
}