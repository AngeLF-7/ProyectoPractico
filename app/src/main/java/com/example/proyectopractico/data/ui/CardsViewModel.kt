package com.example.proyectopractico.data.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectopractico.data.network.RetrofitClient
import kotlinx.coroutines.launch

class CardsViewModel : ViewModel() {

    // Variable que guarda el estado actual de la pantalla (empieza cargando)
    var uiState: CardsUiState by mutableStateOf(CardsUiState.Loading)
        private set

    init {
        // Nada más arrancar la pantalla, pedimos las cartas
        fetchCards()
    }

    // Función para pedir las cartas a la API
    fun fetchCards() {
        uiState = CardsUiState.Loading

        viewModelScope.launch {
            try {
                // Llamamos a la API a través del cliente Retrofit
                val response = RetrofitClient.apiService.getCards()

                if (response.isEmpty()) {
                    uiState = CardsUiState.Empty
                } else {
                    uiState = CardsUiState.Success(response)
                }
            } catch (e: Exception) {
                // Si falla la red o pasa algo raro, mostramos error
                uiState = CardsUiState.Error("No se pudieron cargar las cartas: ${e.message}")
            }
        }
    }
}