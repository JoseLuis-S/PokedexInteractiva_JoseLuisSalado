package com.jlsh.pokedexinteractiva.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.jlsh.pokedexinteractiva.data.Pokemon
import com.jlsh.pokedexinteractiva.ui.componentes.PokemonCard

// Segunda vista de la Pokedex
@Composable
fun VistaCuadricula(pokemons: List<Pokemon>, alPulsarPokemon: (Pokemon) -> Unit) {
    LazyVerticalGrid(
        // Establece el tamaño minimo de cada celda
        columns = GridCells.Adaptive(minSize = 120.dp),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(pokemons) { pokemon ->
            PokemonCard(pokemon = pokemon, alPulsarPokemon = alPulsarPokemon)
        }
    }
}
