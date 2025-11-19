package com.jlsh.pokedexinteractiva.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.jlsh.pokedexinteractiva.ui.navigation.Rutas
import com.jlsh.pokedexinteractiva.ui.PokedexViewModel
import com.jlsh.pokedexinteractiva.ui.screens.DetallesPokemon
import com.jlsh.pokedexinteractiva.ui.screens.PantallaPrincipal

// Componente que se encarga de navegar entre las pantallas de la Pokedex
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    // ViewModel que gestiona los datos
    val viewModel: PokedexViewModel = viewModel()

    NavHost(navController = navController, startDestination = Rutas.PantallaPrincipal) {

        // Pantalla principal
        composable<Rutas.PantallaPrincipal> {
            PantallaPrincipal(
                pokemons = viewModel.pokemons, // -> Datos del ViewModel

                // Funcion lambda para navegar entre pantallas al pulsar el boton o Pokemon
                alPulsarPokemon = { clickedId ->
                    navController.navigate(Rutas.PokedexDetalles(pokemonId = clickedId))
                }
            )
        }

        // Pantalla de detalles al pulsar un Pokemon
        dialog<Rutas.PokedexDetalles> { backStackEntry -> // -> Se usa dialog para que se ponga
                                                          // encima de la otra pantalla

            // Almacena el contexto de la pantalla anterior para permitirte tenerla de fondo
            val ruta = backStackEntry.toRoute<Rutas.PokedexDetalles>()

            // Filtra el Pokemon pulsado por su id para mostrar sus detalles
            val pokemon = remember(ruta.pokemonId) {
                viewModel.getPokemonById(ruta.pokemonId)
            }

            // En caso de que encontrar el Pokemon muestra sus detalles
            if (pokemon != null) {
                DetallesPokemon(
                    pokemon = pokemon,
                    alCerrar = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}