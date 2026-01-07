package com.jlsh.pokedexinteractiva.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jlsh.pokedexinteractiva.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _authState = MutableStateFlow<AuthState>(AuthState.Idle)
    val authState: StateFlow<AuthState> = _authState

    fun loadUserRole(uid: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            try {
                val role = repository.getUserRole(uid)
                _authState.value = AuthState.Authenticated(role)
            } catch (e: Exception) {
                _authState.value = AuthState.Error(e.message ?: "Error al cargar perfil")
            }
        }
    }
}