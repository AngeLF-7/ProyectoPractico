package com.example.proyectopractico

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.proyectopractico.data.ui.CardsViewModel
import com.example.proyectopractico.ui.CardsScreen

class MainActivity : ComponentActivity() {

    private val cardsViewModel: CardsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setContent de androidx.activity.compose.setContent
        setContent {
            CardsScreen(viewModel = cardsViewModel)
        }
    }
}