package com.example.pokemon

import android.util.Log
import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmkoin.utils.Status
import com.example.pokemon.data.Results
import com.example.pokemon.data.pokemonDetails.Pokemon
import com.example.pokemon.repository.PokemonRepository
import com.example.pokemon.utils.NetworkHelper
import com.example.pokemon.utils.Resource
import com.example.pokemon.utils.StringType
import kotlinx.coroutines.launch

class MainViewModel (
    private val pokeRepository: PokemonRepository,
    private val networkHelper: NetworkHelper
    ): ViewModel() {

    private val pokemonLD = MutableLiveData<List<Pokemon>>()
    val pokemon: LiveData<List<Pokemon>> = pokemonLD

    private val messageLD = MutableLiveData<StringType>()
    val message: LiveData<StringType> = messageLD

    private val attributesList: ArrayList<Pokemon> = arrayListOf()

    init {
        fetchPokemon()
    }

    fun fetchPokemon() {
        viewModelScope.launch {
            if (networkHelper.isNetworkConnected()) {
                pokeRepository.getAllPokemon().let {
                    if (it.status == Status.SUCCESS) {
                        Log.d("pokemon", "fetchPokemon: " + it.data)
                        it.data?.let { it1 -> fetchUrls(it1) }
                        //it.data?.results?.let { pokeList -> pokemonList.addAll(pokeList) }
                        //successLD.value = it.data?.results
                    } else {
                        messageLD.value = StringType.StringRaw(it.msg.toString())
                    }
                }
            } else messageLD.value = StringType.StringResource(R.string.no_internet)
        }
    }

    fun fetchUrls(pokemonUrl: List<String>){
        pokemonUrl.forEach { url ->          //each "url" from the list of string urls is looped
            viewModelScope.launch {
                pokeRepository.getPokemonDetails(url).let {
                    if(it.status == Status.SUCCESS) {
                        it.data?.let { it1 -> attributesList.add(it1) }
                        pokemonLD.value = attributesList
                    } else {
                        messageLD.value = StringType.StringRaw(it.msg.toString())
                    }
                }
            }
        }
    }
}

