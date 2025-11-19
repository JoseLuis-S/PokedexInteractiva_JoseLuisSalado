package com.jlsh.pokedexinteractiva.data

import com.jlsh.pokedexinteractiva.R
import com.jlsh.pokedexinteractiva.data.TipoPokemon

// Funcion que retorna una lista con Pokemons
fun getPokemons(): List<Pokemon> {
    return listOf(
        Pokemon(
            id = 1,
            nombre = "Bulbasaur",
            tipo = listOf(TipoPokemon.PLANTA, TipoPokemon.VENENO),
            descripcion = "Este Pokémon nace con una semilla en el lomo. Con el tiempo, la semilla se hace más y más grande.",
            imagen = R.drawable.bulbasaur
        ),
        Pokemon(
            id = 2,
            nombre = "Ivysaur",
            tipo = listOf(TipoPokemon.PLANTA, TipoPokemon.VENENO),
            descripcion = "Para soportar el peso del brote que tiene en el lomo, sus patas y su tronco se vuelven más fuertes y robustos.",
            imagen = R.drawable.ivysaur
        ),
        Pokemon(
            id = 3,
            nombre = "Venusaur",
            tipo = listOf(TipoPokemon.PLANTA, TipoPokemon.VENENO),
            descripcion = "La luz solar que absorbe la flor de su lomo le permite recobrar fuerzas. Por eso en verano está más activo.",
            imagen = R.drawable.venusaur
        ),
        Pokemon(
            id = 4,
            nombre = "Charmander",
            tipo = listOf(TipoPokemon.FUEGO),
            descripcion = "La llama de su cola indica su fuerza vital. Si está débil, la llama arderá más tenuemente.",
            imagen = R.drawable.charmander
        ),
        Pokemon(
            id = 5,
            nombre = "Charmeleon",
            tipo = listOf(TipoPokemon.FUEGO),
            descripcion = "Este Pokémon de naturaleza bárbara busca rivales constantemente. No se calmará hasta haber derrotado a su oponente.",
            imagen = R.drawable.charmeleon
        ),
        Pokemon(
            id = 6,
            nombre = "Charizard",
            tipo = listOf(TipoPokemon.FUEGO, TipoPokemon.VOLADOR),
            descripcion = "Escupe un fuego tan caliente que funde las rocas. Causa incendios forestales sin querer.",
            imagen = R.drawable.charizard
        ),
        Pokemon(
            id = 7,
            nombre = "Squirtle",
            tipo = listOf(TipoPokemon.AGUA),
            descripcion = "Cuando retrae su largo cuello en el caparazón, dispara agua a una presión increíble.",
            imagen = R.drawable.squirtle
        ),
        Pokemon(
            id = 8,
            nombre = "Wartortle",
            tipo = listOf(TipoPokemon.AGUA),
            descripcion = "Se lo considera un símbolo de longevidad. Los más ancianos tienen un caparazón cubierto de algas.",
            imagen = R.drawable.wartortle
        ),
        Pokemon(
            id = 9,
            nombre = "Blastoise",
            tipo = listOf(TipoPokemon.AGUA),
            descripcion = "Los chorros de agua que le salen por los cañones que tiene en el caparazón pueden derribar el acero.",
            imagen = R.drawable.blastoise
        ),
        Pokemon(
            id = 10,
            nombre = "Caterpie",
            tipo = listOf(TipoPokemon.BICHO),
            descripcion = "Para protegerse, despide un hedor terrible por las antenas que le salen en la cabeza.",
            imagen = R.drawable.caterpie
        ),
        Pokemon(
            id = 11,
            nombre = "Metapod",
            tipo = listOf(TipoPokemon.BICHO),
            descripcion = "Como su caparazón es muy duro, en esta fase solo puede fortalecerse. Permanece inmóvil para evitar los ataques.",
            imagen = R.drawable.metapod
        ),
        Pokemon(
            id = 12,
            nombre = "Butterfree",
            tipo = listOf(TipoPokemon.BICHO, TipoPokemon.VOLADOR),
            descripcion = "Aletea a gran velocidad para lanzar al aire sus escamas, que son altamente tóxicas.",
            imagen = R.drawable.butterfree
        ),
        Pokemon(
            id = 13,
            nombre = "Weedle",
            tipo = listOf(TipoPokemon.BICHO, TipoPokemon.VENENO),
            descripcion = "El aguijón de la cabeza es muy venenoso. Su llamativo color tiene como función advertir a sus enemigos.",
            imagen = R.drawable.weedle
        ),
        Pokemon(
            id = 14,
            nombre = "Kakuna",
            tipo = listOf(TipoPokemon.BICHO, TipoPokemon.VENENO),
            descripcion = "Permanece prácticamente inmóvil, agarrado a un árbol, pero por dentro se prepara para su próxima evolución.",
            imagen = R.drawable.kakuna
        ),
        Pokemon(
            id = 15,
            nombre = "Beedrill",
            tipo = listOf(TipoPokemon.BICHO, TipoPokemon.VENENO),
            descripcion = "Tiene tres aguijones venenosos. El de la cola es el que inocula el veneno más potente.",
            imagen = R.drawable.beedrill
        ),
        Pokemon(
            id = 16,
            nombre = "Pidgey",
            tipo = listOf(TipoPokemon.NORMAL, TipoPokemon.VOLADOR),
            descripcion = "Es muy dócil. Si se le ataca, suele agitar sus alas para levantar una polvareda y protegerse.",
            imagen = R.drawable.pidgey
        ),
        Pokemon(
            id = 17,
            nombre = "Pidgeotto",
            tipo = listOf(TipoPokemon.NORMAL, TipoPokemon.VOLADOR),
            descripcion = "Su extraordinaria vista le permite avistar a sus presas desde grandes alturas. Sus garras están muy desarrolladas.",
            imagen = R.drawable.pidgeotto
        ),
        Pokemon(
            id = 18,
            nombre = "Pidgeot",
            tipo = listOf(TipoPokemon.NORMAL, TipoPokemon.VOLADOR),
            descripcion = "Vuela a una velocidad de 2 mach en busca de presas. Sus grandes garras son armas muy peligrosas.",
            imagen = R.drawable.pidgeot
        ),
        Pokemon(
            id = 19,
            nombre = "Rattata",
            tipo = listOf(TipoPokemon.NORMAL),
            descripcion = "Es cauto a más no poder. La robustez de sus colmillos le permite roer cualquier cosa.",
            imagen = R.drawable.rattata
        ),
        Pokemon(
            id = 20,
            nombre = "Raticate",
            tipo = listOf(TipoPokemon.NORMAL),
            descripcion = "Sus bigotes le sirven para guardar el equilibrio. Parece que se vuelve más lento si se los cortan.",
            imagen = R.drawable.raticate
        ),
        Pokemon(
            id = 21,
            nombre = "Spearow",
            tipo = listOf(TipoPokemon.NORMAL, TipoPokemon.VOLADOR),
            descripcion = "Aletea con sus cortas alas para espantar a los insectos de la hierba alta y los atrapa con el pico.",
            imagen = R.drawable.spearow
        ),
        Pokemon(
            id = 22,
            nombre = "Fearow",
            tipo = listOf(TipoPokemon.NORMAL, TipoPokemon.VOLADOR),
            descripcion = "Gracias a su majestuoso cuello y su largo pico, puede atrapar a sus presas en tierra o en el agua.",
            imagen = R.drawable.fearow
        ),
        Pokemon(
            id = 23,
            nombre = "Ekans",
            tipo = listOf(TipoPokemon.VENENO),
            descripcion = "Se enrosca para descansar. Desde esa posición, puede responder a cualquier amenaza desde cualquier dirección.",
            imagen = R.drawable.ekans
        ),
        Pokemon(
            id = 24,
            nombre = "Arbok",
            tipo = listOf(TipoPokemon.VENENO),
            descripcion = "Se han identificado seis variaciones de los terroríficos dibujos de su piel. Estos varían según la zona.",
            imagen = R.drawable.arbok
        ),
        Pokemon(
            id = 25,
            nombre = "Pikachu",
            tipo = listOf(TipoPokemon.ELECTRICO),
            descripcion = "Cuanta más energía eléctrica genera, más suaves y elásticas se vuelven las bolsas de sus mejillas.",
            imagen = R.drawable.pikachu
        ),
        Pokemon(
            id = 26,
            nombre = "Raichu",
            tipo = listOf(TipoPokemon.ELECTRICO),
            descripcion = "Su larga cola le sirve para protegerse a sí mismo de su potente voltaje. Puede descargar hasta 100 000 voltios.",
            imagen = R.drawable.raichu
        )
    )
}
