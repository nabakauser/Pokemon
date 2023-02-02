package com.example.pokemon.module

import com.example.pokemon.data.Pokedex
import com.example.pokemon.data.pokemonDetails.Pokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface PokeInterface {

    @GET("pokemon?")
    suspend fun getAllPokemon(@Query("limit")limit: Int,
                               @Query("offset")offset: Int): Response<Pokedex>

//    @GET("pokemon/{id}")
//    suspend fun getPokemonDetails(@Path("id")id: Int): Response<Pokemon>

    @GET
    suspend fun getPokemonAttributes(@Url url: String): Response<Pokemon>

}

//https://pokeapi.co/api/v2/pokemon?limit=100&offset=0
//https://pokeapi.co/api/v2/pokemon/1/