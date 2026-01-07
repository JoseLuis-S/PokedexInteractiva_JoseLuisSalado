package com.jlsh.pokedexinteractiva.ui.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jlsh.pokedexinteractiva.domain.SignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState = _uiState.asStateFlow()

    fun onEmailChanged(newValue: String) {
        _uiState.update { it.copy(email = newValue, error = null) }
    }

    fun onPasswordChanged(newValue: String) {
        _uiState.update { it.copy(password = newValue, error = null) }
    }

    fun login(onSuccess: (String) -> Unit) {
        val email = uiState.value.email.trim()
        val password = uiState.value.password.trim()

        if (email.isBlank() || password.isBlank()) {
            _uiState.update { it.copy(error = "Campos obligatorios") }
            return
        }

        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }

            val result = signInUseCase.signIn(email, password)

            if (result.isSuccess) {
                val uid = signInUseCase.getCurrentUser()?.uid
                if (uid != null) {
                    _uiState.update { it.copy(isLoading = false) }
                    onSuccess(uid)
                } else {
                    _uiState.update { it.copy(isLoading = false, error = "Error al recuperar sesión") }
                }
            } else {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = result.exceptionOrNull()?.message ?: "Error desconocido"
                    )
                }
            }
        }
    }
}