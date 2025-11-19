package com.jlsh.pokedexinteractiva.ui.navigation

import kotlinx.serialization.Serializable

// Guarda las rutas de navegacion de forma segura, asegurandose que AppNavigation unicamente
// reciba objetos que hereden de rutas y evitando crashes durante la navegacion
sealed interface Rutas {
    @Serializable
    data object PantallaPrincipal : Rutas

    @Serializable
    data class PokedexDetalles(val pokemonId: Int) : Rutas
}