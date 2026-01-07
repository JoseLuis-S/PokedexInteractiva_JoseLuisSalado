package com.jlsh.pokedexinteractiva.data

import com.jlsh.pokedexinteractiva.data.TipoPokemon

data class Pokemon(
    val id: Int,
    val nombre: String,
    val tipo: List<TipoPokemon>,
    val descripcion: String,
    val imagen: Int
)