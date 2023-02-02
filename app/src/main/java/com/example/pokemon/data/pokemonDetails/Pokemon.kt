package com.example.pokemon.data.pokemonDetails

import com.google.gson.annotations.SerializedName

data class Pokemon (
    val id: Int?,
    val name: String?,
    @SerializedName("base_experience")
    val experience: Int?,
    val height: Int?,
    val weight: Int?,
    val sprites: Sprites?,
)