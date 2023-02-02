package com.example.pokemon.ui.displayAttributes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pokemon.R
import com.example.pokemon.adapter.ViewPagerAdapter
import com.example.pokemon.databinding.ActivityDisplayPokemonBinding
import com.example.pokemon.ui.main.MainActivity

class  DisplayPokemonActivity : AppCompatActivity() {
    private var binding: ActivityDisplayPokemonBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayPokemonBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setUpUi()
    }

    private fun setUpUi() {
        val images = listOf(
            R.drawable.sd,
            R.drawable.w1,
            R.drawable.wings
        )
        val adapter = ViewPagerAdapter(images)
        val viewPager = binding?.uiViewPager
        val dots = binding?.uiDots
        viewPager?.adapter = adapter
        if (viewPager != null) {
            dots?.setViewPager2(viewPager)
        }

    }
}