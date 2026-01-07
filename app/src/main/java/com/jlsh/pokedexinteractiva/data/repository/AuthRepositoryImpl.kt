package com.jlsh.pokedexinteractiva.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.jlsh.pokedexinteractiva.data.AuthDataSource
import jakarta.inject.Inject
import kotlinx.coroutines.tasks.await

class AuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth,
    private val authDataSource: AuthDataSource,
    private val db: FirebaseFirestore
) : AuthRepository {

    override suspend fun signIn(email: String, password: String): Result<String> {
        return try {
            val uid = authDataSource.signIn(email, password)
            Result.success(uid)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getUserRole(uid: String): String {
        return try {
            val snapshot = db.collection("users").document(uid).get().await()
            snapshot.getString("role") ?: "USER"
        } catch (e: Exception) {
            "USER"
        }
    }

    override fun getCurrentUser(): FirebaseUser? = auth.currentUser
}