package com.example.proyectopractico.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.proyectopractico.data.ui.CardsUiState
import com.example.proyectopractico.data.ui.CardsViewModel
import com.example.proyectopractico.ui.components.CardItem

@Composable
fun CardsScreen(viewModel: CardsViewModel) {
    // Escuchamos el estado actual del ViewModel (semáforo)
    val state = viewModel.uiState

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Segun el estado, mostramos una pantalla u otra
        when (state) {
            is CardsUiState.Loading -> {
                // Estado 1: Carga
                CircularProgressIndicator()
            }
            is CardsUiState.Success -> {
                // Estado 2: Exito -> Lista scrollable con LazyColumn
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(vertical = 8.dp)
                ) {
                    items(state.cards) { card ->
                        CardItem(card = card)
                    }
                }
            }
            is CardsUiState.Error -> {
                // Estado 3: Error
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = state.message)
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = { viewModel.fetchCards() }) {
                        Text(text = "Reintentar")
                    }
                }
            }
            is CardsUiState.Empty -> {
                // Estado 4: Lista vacía
                Text(text = "No hay cartas disponibles.")
            }
        }
    }
}