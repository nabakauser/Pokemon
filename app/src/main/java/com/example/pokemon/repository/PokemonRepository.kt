package com.example.pokemon.repository

import com.example.pokemon.module.PokeInterface
import com.example.pokemon.data.pokemonDetails.Pokemon
import com.example.pokemon.mapper.AttributesMapper
import com.example.pokemon.mapper.PokeMapper
import com.example.pokemon.utils.Resource

class PokemonRepository (
    private val apiInterface: PokeInterface
) {

    suspend fun getAllPokemon(): Resource<List<String>?> {
        return PokeMapper.map(apiInterface.getAllPokemon(20, 0))

    }

    suspend fun getPokemonDetails(url : String) :Resource<Pokemon> {
        return AttributesMapper.getAttributes(apiInterface.getPokemonAttributes(url))
    }
}