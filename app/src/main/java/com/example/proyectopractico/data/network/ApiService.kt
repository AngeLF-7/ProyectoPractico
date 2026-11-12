package com.example.proyectopractico.data.network

import com.example.proyectopractico.data.model.CardModel
import retrofit2.http.GET

// Interfaz donde definimos las operaciones HTTP de nuestra API REST
interface ApiService {

    // Peticion GET a la ruta relativa del archivo JSON de cartas
    @GET("json/cards.json")
    suspend fun getCards(): List<CardModel>
}