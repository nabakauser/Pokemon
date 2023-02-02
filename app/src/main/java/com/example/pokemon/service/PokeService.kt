package com.example.pokemon

import com.example.pokemon.module.PokeInterface
import com.example.pokemon.warehouse.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.component.KoinComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestHelper : KoinComponent {

    private fun loggingInterceptor() =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    private fun httpClient() =
        OkHttpClient.Builder().apply {
            addInterceptor(loggingInterceptor())
                .addInterceptor { chain ->
                    val builder = chain.request().newBuilder()
                    return@addInterceptor chain.proceed(builder.build())
                }
        }.build()

    private val retrofit = Retrofit.Builder().apply {
        baseUrl(BASE_URL)
        addConverterFactory(GsonConverterFactory.create())
        client(httpClient())
    }.build()

    val client : PokeInterface by lazy { retrofit.create(PokeInterface::class.java) }
}
