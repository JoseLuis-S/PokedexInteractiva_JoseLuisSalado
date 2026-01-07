package com.jlsh.pokedexinteractiva.domain

import com.google.firebase.auth.FirebaseUser
import com.jlsh.pokedexinteractiva.data.repository.AuthRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend fun signIn(email: String, password: String) =
        repository.signIn(email, password)

    fun getCurrentUser(): FirebaseUser? =
        repository.getCurrentUser()
}