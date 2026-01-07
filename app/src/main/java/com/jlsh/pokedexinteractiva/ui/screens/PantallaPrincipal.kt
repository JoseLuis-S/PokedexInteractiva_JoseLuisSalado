package com.jlsh.pokedexinteractiva.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.jlsh.pokedexinteractiva.data.Pokemon

// EnumClass para las diferentes vistas de la Pokedex
enum class VistaPokedex(val nombre: String) {
    LISTA_VERTICAL("Vertical"),
    CUADRICULA("Cuadricula"),
    AGRUPADA("Agrupada"),
    ADMIN("Gestión Admin")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPrincipal(
    userRole: String?,
    pokemons: List<Pokemon>,
    alPulsarPokemon: (Int) -> Unit
) {
    // Almacena en cual de las vista esta la Pokedex
    var vistaActual by remember { mutableStateOf(VistaPokedex.LISTA_VERTICAL) }
    val context = LocalContext.current

    Scaffold(
        // TopBar con el nombre de la app
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Pokedex Interactiva") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { paddingValues ->
        // Muestra las posibles vistas de la Pokedex
        Column(modifier = Modifier.padding(paddingValues)) {
            TabRow(selectedTabIndex = vistaActual.ordinal) {
                VistaPokedex.entries.forEach { viewType ->
                    Tab(
                        selected = vistaActual == viewType,
                        onClick = {
                            if (viewType == VistaPokedex.ADMIN && userRole != "ADMIN") {
                                Toast.makeText(context, "Acceso denegado: Se requiere ser Admin", Toast.LENGTH_SHORT).show()
                            } else {
                                vistaActual = viewType
                            }
                        },
                        text = { Text(viewType.nombre) }
                    )
                }
            }

            // En funcion del valor de vistaActual muestra la vista correspondiente
            when (vistaActual) {
                VistaPokedex.LISTA_VERTICAL -> ListaVertical(pokemons = pokemons) { pokemon ->
                    alPulsarPokemon(pokemon.id)
                }
                VistaPokedex.CUADRICULA -> VistaCuadricula(pokemons = pokemons) { pokemon ->
                    alPulsarPokemon(pokemon.id)
                }
                VistaPokedex.AGRUPADA -> VistaAgrupada(pokemons = pokemons) { pokemon ->
                    alPulsarPokemon(pokemon.id)
                }
                VistaPokedex.ADMIN -> PantallaAdmin()
            }
        }
    }
}