package com.jlsh.pokedexinteractiva.ui.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jlsh.pokedexinteractiva.data.Pokemon
import com.jlsh.pokedexinteractiva.data.TipoPokemon

// Fila que contiene imagen del Pokemon, su nombre y sus tipos
@Composable
fun PokemonRow(pokemon: Pokemon, alPulsarPokemon: (Pokemon) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { alPulsarPokemon(pokemon) }
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Imagen del Pokemon
        Image(
            painter = painterResource(id = pokemon.imagen),
            contentDescription = "Imagen de ${pokemon.nombre}",
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .background(Color.LightGray.copy(alpha = 0.5f))
        )

        Spacer(modifier = Modifier.width(16.dp))

        // Columna con nombre y tipos del pokemon
        Column {
            // Nombre del Pokemon
            Text(text = pokemon.nombre, fontWeight = FontWeight.Bold, fontSize = 18.sp)

            // Tipos del Pokemon
            Row {
                pokemon.tipo.forEach { tipoPokemon ->
                    ComponenteTipo(tipo = tipoPokemon)
                }
            }
        }
    }
}

// Muestra imagen y nombre del Pokemon
@Composable
fun PokemonCard(pokemon: Pokemon, alPulsarPokemon: (Pokemon) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable { alPulsarPokemon(pokemon) },
        shape = RoundedCornerShape(16.dp),
        // Muestra Card por encima del fondo de la pantalla
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Imagen del Pokemon
            Image(
                painter = painterResource(id = pokemon.imagen),
                contentDescription = "Sprite de ${pokemon.nombre}",
                modifier = Modifier.size(96.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = pokemon.nombre, fontWeight = FontWeight.Bold)
        }
    }
}

// Elemento del tipo de un Pokemon
@Composable
fun ComponenteTipo(tipo: TipoPokemon) {
    Box(
        modifier = Modifier
            .padding(end = 4.dp, top = 4.dp)
            .background(
                color = tipo.color,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        // Tipo del Pokemon
        Text(text = tipo.name, color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
    }
}

// Cabecera para separar por tipos de Pokemon
@Composable
fun CabeceraTipo(tipo: TipoPokemon) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(tipo.color)
            .padding(16.dp)
    ) {
        Text(
            text = tipo.name,
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
