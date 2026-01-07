package com.jlsh.pokedexinteractiva.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.jlsh.pokedexinteractiva.data.Pokemon
import com.jlsh.pokedexinteractiva.ui.componentes.CabeceraTipo
import com.jlsh.pokedexinteractiva.ui.componentes.PokemonRow

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VistaAgrupada(pokemons: List<Pokemon>, alPulsarPokemon: (Pokemon) -> Unit) {
    // Agrupa los Pokemons por su primer tipo
    val pokemonPorTipos = pokemons.groupBy { it.tipo.first() }

    LazyColumn {
        pokemonPorTipos.forEach { (tipoPokemon, pokemonList) ->
            // Fija la cabecera que separa por tipos a la parte superior hasta
            // que haya otro stickyHeader
            stickyHeader {
                CabeceraTipo(tipo = tipoPokemon)
            }
            items(pokemonList) { pokemon ->
                PokemonRow(pokemon = pokemon, alPulsarPokemon = alPulsarPokemon)
            }
        }
    }
}
