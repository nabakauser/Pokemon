package com.example.pokemon.mapper

import android.view.animation.Transformation
import androidx.lifecycle.Transformations
import com.example.pokemon.data.Pokedex
import com.example.pokemon.data.Results
import com.example.pokemon.data.pokemonDetails.Pokemon
import com.example.pokemon.utils.Resource
import retrofit2.Response

class PokeMapper {
    companion object {
        fun map(pokemon : Response<Pokedex>) : Resource<List<String>?> {
            return if (pokemon.isSuccessful){
                 Resource.success(getUrlFromResults(pokemon.body()?.results))
            }else Resource.error(pokemon.message())
        }

        private fun getUrlFromResults(pokemonArray: List<Results>?): List<String> {
            return (pokemonArray?.map { results ->
                results.url ?: ""
            } ?: arrayListOf())
        }


    }
}