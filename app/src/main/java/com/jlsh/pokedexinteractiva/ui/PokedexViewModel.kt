package com.jlsh.pokedexinteractiva.ui

import androidx.lifecycle.ViewModel
import com.jlsh.pokedexinteractiva.data.Pokemon
import com.jlsh.pokedexinteractiva.data.getPokemons
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

// ViewModel para la pantalla principal de la Pokedex
@HiltViewModel
class PokedexViewModel @Inject constructor() : ViewModel() {
    // Variable privada que contiene la lista de Pokemons
    private val _pokemons = getPokemons()
    // Variable que se expone a la vista
    val pokemons = _pokemons

    // Filtra el Pokemon por su id
    fun getPokemonById(id: Int): Pokemon? {
        return _pokemons.find { it.id == id }
    }
}