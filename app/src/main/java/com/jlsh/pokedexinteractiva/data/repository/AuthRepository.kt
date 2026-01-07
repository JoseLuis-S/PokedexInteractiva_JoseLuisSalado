package com.jlsh.pokedexinteractiva.data.repository

import com.google.firebase.auth.FirebaseUser

interface AuthRepository {
    suspend fun signIn(email: String, password: String): Result<String>
    suspend fun getUserRole(uid: String): String
    fun getCurrentUser(): FirebaseUser?
}