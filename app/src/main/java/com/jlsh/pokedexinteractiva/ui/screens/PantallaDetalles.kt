package com.jlsh.pokedexinteractiva.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jlsh.pokedexinteractiva.data.Pokemon
import com.jlsh.pokedexinteractiva.ui.componentes.ComponenteTipo

// Muestra los detalles de un Pokemon al pulsarlo
@Composable
fun DetallesPokemon(
    pokemon: Pokemon,
    alCerrar: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(16.dp)
            // Con wrapContentSize toma el tamaño que necesita
            .wrapContentSize(),
        // Muestra el card por encima del fondo de la pantalla
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Imagen del Pokemon
            Image(
                painter = painterResource(id = pokemon.imagen),
                contentDescription = null,
                modifier = Modifier.size(180.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Nombre del Pokemon
            Text(text = pokemon.nombre, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(8.dp))

            // Tipos del Pokemon
            Row {
                pokemon.tipo.forEach { tipoPokemon ->
                    ComponenteTipo(tipo = tipoPokemon)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Descripcion de Pokemon
            Text(
                text = pokemon.descripcion,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Boton para salir de los detalles del Pokemon
            Button(onClick = alCerrar) {
                Text("Cerrar")
            }
        }
    }
}