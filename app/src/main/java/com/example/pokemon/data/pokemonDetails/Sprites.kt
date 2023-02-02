package com.example.pokemon.data.pokemonDetails

import com.google.gson.annotations.SerializedName

data class Sprites (
    @SerializedName("back_default")
    val backDefault: String?,
    @SerializedName("back_shiny")
    val backShiny: String?,
    @SerializedName("front_default")
    val frontDefault: String?,
    @SerializedName("front_shiny")
    val frontShiny: String?,
)
//    back_default	:	https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/1.png
//    back_shiny	:	https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/shiny/1.png
//    front_default	:	https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png
//    front_shiny	:	https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/1.png