package com.example.pokemon.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.pokemon.ui.displayAttributes.DisplayPokemonActivity
import com.example.pokemon.MainViewModel
import com.example.pokemon.adapter.PokemonAdapter
import com.example.pokemon.data.pokemonDetails.Pokemon
import com.example.pokemon.databinding.ActivityMainBinding
import com.example.pokemon.module.PokeInterface
import com.example.pokemon.repository.PokemonRepository
import com.example.pokemon.utils.StringType
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private val pokeViewModel: MainViewModel by viewModel()
//    private var viewModel: MainViewModel? = null
//    private var apiInterface: PokeInterface? = null
//    private var repository: PokemonRepository? = null
    private val pokeAdapter: PokemonAdapter by lazy {
        PokemonAdapter (
            pokemonList = arrayListOf(),
            onItemClick = { navigateToDisplayPokemonImagesActivity() }
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setUpUi()
        setUpObserver()
//
//        repository = PokemonRepository()
//        viewModel = MainViewModel()

    }

    private fun setUpUi() {
        binding?.uiRvPokemon?.apply {
            adapter = pokeAdapter
        }
    }

    private fun setPokemonListToUi(pokemon : List<Pokemon>) {
        pokeAdapter.onListChanged(pokemon)
    }

    private fun setUpObserver() {
        showToast()
        pokeViewModel.pokemon.observe(this) {
            it?.let { it1 -> setPokemonListToUi(it1) }
        }
        pokeViewModel.message.observe(this) {
        }
    }

    private fun showToast() {
        pokeViewModel.message.observe(this) { message ->
            when (message) {
                is StringType.StringResource -> {
                    Toast.makeText(this, getString(message.id), Toast.LENGTH_SHORT).show()
                }
                is StringType.StringRaw -> {
                    Toast.makeText(this, message.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun navigateToDisplayPokemonImagesActivity() {
        val intent = Intent(this, DisplayPokemonActivity::class.java)
        startActivity(intent)
    }
}