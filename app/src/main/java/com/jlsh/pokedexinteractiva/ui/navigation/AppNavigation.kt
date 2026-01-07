package com.jlsh.pokedexinteractiva.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.jlsh.pokedexinteractiva.ui.PokedexViewModel
import com.jlsh.pokedexinteractiva.ui.screens.AuthState
import com.jlsh.pokedexinteractiva.ui.screens.DetallesPokemon
import com.jlsh.pokedexinteractiva.ui.screens.MainViewModel
import com.jlsh.pokedexinteractiva.ui.screens.PantallaPrincipal
import com.jlsh.pokedexinteractiva.ui.screens.login.PantallaLogin

@Composable
fun AppNavigation(
    mainViewModel: MainViewModel = hiltViewModel(),
    pokedexViewModel: PokedexViewModel = hiltViewModel()
) {
    val navController = rememberNavController()

    val authState by mainViewModel.authState.collectAsState()

    NavHost(
        navController = navController,
        startDestination = Rutas.Login
    ) {

        composable<Rutas.Login> {
            PantallaLogin(
                onLoginSuccess = { uid ->
                    mainViewModel.loadUserRole(uid)

                    navController.navigate(Rutas.PantallaPrincipal) {
                        popUpTo(Rutas.Login) { inclusive = true }
                    }
                }
            )
        }

        composable<Rutas.PantallaPrincipal> {
            val role = (authState as? AuthState.Authenticated)?.role

            PantallaPrincipal(
                userRole = role,
                pokemons = pokedexViewModel.pokemons,
                alPulsarPokemon = { clickedId ->
                    navController.navigate(Rutas.PokedexDetalles(pokemonId = clickedId))
                }
            )
        }

        dialog<Rutas.PokedexDetalles> { backStackEntry ->
            val ruta = backStackEntry.toRoute<Rutas.PokedexDetalles>()

            val pokemon = remember(ruta.pokemonId) {
                pokedexViewModel.getPokemonById(ruta.pokemonId)
            }

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