package com.jlsh.pokedexinteractiva.ui.screens.login

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.jlsh.pokedexinteractiva.ui.componentes.AuthErrorMessage
import com.jlsh.pokedexinteractiva.ui.componentes.AuthHeader
import com.jlsh.pokedexinteractiva.ui.componentes.PasswordTextField
import com.jlsh.pokedexinteractiva.ui.componentes.PrimaryButton
import com.jlsh.pokedexinteractiva.ui.componentes.PrimaryTextField
import com.jlsh.pokedexinteractiva.ui.componentes.AuthScreenLayout

@Composable
fun LoginScreen(
    state: LoginUiState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit,
) {
    AuthScreenLayout {

        Spacer(modifier = Modifier.height(60.dp))

        AuthHeader(
            title = "¡Bienvenido entrenador!",
            subtitle = "Inicia sesión para continuar"
        )

        Spacer(modifier = Modifier.height(40.dp))

        PrimaryTextField(
            value = state.email,
            onValueChange = onEmailChange,
            label = "Email",
            placeholder = "you@example.com",
            keyboardType = KeyboardType.Email
        )

        Spacer(modifier = Modifier.height(20.dp))

        PasswordTextField(
            value = state.password,
            onValueChange = onPasswordChange,
            label = "Password"
        )

        AuthErrorMessage(error = state.error)

        Spacer(modifier = Modifier.height(32.dp))

        PrimaryButton(
            text = if (state.isLoading) "Logging in..." else "LOGIN",
            enabled = !state.isLoading,
            onClick = onLoginClick,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    MaterialTheme {
        LoginScreen(
            state = LoginUiState(email = "test@test.com", isLoading = false),
            onEmailChange = {},
            onPasswordChange = {},
            onLoginClick = {}
        )
    }
}

@Composable
fun PantallaLogin(
    viewModel: LoginViewModel = hiltViewModel(),
    onLoginSuccess: (String) -> Unit
) {
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(state) {
    }

    LoginScreen(
        state = state,
        onEmailChange = { viewModel.onEmailChanged(it) },
        onPasswordChange = { viewModel.onPasswordChanged(it) },
        onLoginClick = {
            viewModel.login(onSuccess = { uid ->
                onLoginSuccess(uid)
            })
        }
    )
}
