package com.jlsh.pokedexinteractiva

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.jlsh.pokedexinteractiva.ui.navigation.AppNavigation
import com.jlsh.pokedexinteractiva.ui.theme.PokedexInteractivaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexInteractivaTheme {
                AppNavigation()
            }
        }
    }
}
