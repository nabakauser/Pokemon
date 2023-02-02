package com.example.pokemon.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemon.R
import com.example.pokemon.data.pokemonDetails.Pokemon
import com.example.pokemon.data.pokemonDetails.Sprites
import com.squareup.picasso.Picasso

class ViewPagerAdapter (
    //val pokemonImages: ArrayList<Sprites>
    private val images: List<Int>
): RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.swipe_image_layout,parent,false)
        return ViewPagerHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        val imagePosition = images[position]
        holder.uiIvSwipeImages.setImageResource(imagePosition)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    inner class ViewPagerHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var uiIvSwipeImages: ImageView = itemView.findViewById(R.id.uiIvSwipeImages)
    }
}