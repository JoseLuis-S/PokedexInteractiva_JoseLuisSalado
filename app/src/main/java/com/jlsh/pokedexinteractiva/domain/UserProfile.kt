package com.jlsh.pokedexinteractiva.domain

data class UserProfile(
    val uid: String = "",
    val email: String = "",
    val role: String = "USER"
)