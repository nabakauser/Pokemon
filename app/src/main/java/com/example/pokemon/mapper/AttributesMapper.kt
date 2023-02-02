package com.example.pokemon.mapper

import com.example.pokemon.data.pokemonDetails.Pokemon
import com.example.pokemon.utils.Resource
import retrofit2.Response

class AttributesMapper {
    companion object {
        fun getAttributes(pokemonResponse : Response<Pokemon>): Resource<Pokemon> {
            return if(pokemonResponse.isSuccessful) {
                Resource.success(pokemonResponse.body())
            } else {
                Resource.error(pokemonResponse.message())
            }
        }
    }
}