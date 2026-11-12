package com.example.proyectopractico.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Singleton encargado de instanciar y configurar el cliente Retrofit
object RetrofitClient {

    private const val BASE_URL = "https://royaleapi.github.io/cr-api-data/"

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}