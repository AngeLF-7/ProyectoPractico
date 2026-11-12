package com.example.proyectopractico.data.model

import com.google.gson.annotations.SerializedName

// Objeto Kotlin que representa cada carta de Clash Royale devuelta por el JSON de la API
data class CardModel(
    @SerializedName("key")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("elixir")
    val elixirCost: Int?,

    @SerializedName("type")
    val type: String?,

    @SerializedName("rarity")
    val rarity: String?
) {
    // URL dinámica para obtener la imagen PNG de la carta desde RoyaleAPI
    val imageUrl: String
        get() = "https://royaleapi.github.io/cr-api-assets/cards/$id.png"
}