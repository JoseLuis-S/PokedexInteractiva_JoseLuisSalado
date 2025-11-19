package com.jlsh.pokedexinteractiva.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.jlsh.pokedexinteractiva.data.Pokemon
import com.jlsh.pokedexinteractiva.ui.componentes.PokemonRow

// Primera vista de la Pokedex
@Composable
fun ListaVertical(pokemons: List<Pokemon>, alPulsarPokemon: (Pokemon) -> Unit) {
    LazyColumn(
        // Espacio entre elementos
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        // Muestra todos los pokemons por filas
        items(pokemons) { pokemon ->
            PokemonRow(pokemon = pokemon, alPulsarPokemon = alPulsarPokemon)
        }
    }
}