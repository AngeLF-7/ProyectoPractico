package com.example.proyectopractico.data.ui

import com.example.proyectopractico.data.model.CardModel

// Esta clase define los 4 estados posibles de la pantalla
sealed class CardsUiState {
    object Loading : CardsUiState() // Estado 1: Cargando datos
    data class Success(val cards: List<CardModel>) : CardsUiState() // Estado 2: Éxito (nos da la lista)
    data class Error(val message: String) : CardsUiState() // Estado 3: Error de conexión
    object Empty : CardsUiState() // Estado 4: Lista vacía
}