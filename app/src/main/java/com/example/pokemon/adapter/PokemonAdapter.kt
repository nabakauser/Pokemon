package com.example.pokemon.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemon.R
import com.example.pokemon.data.pokemonDetails.Pokemon
import com.squareup.picasso.Picasso

class PokemonAdapter(
    private val pokemonList: ArrayList<Pokemon>,
    private val onItemClick: (Pokemon) -> Unit,
): RecyclerView.Adapter<PokemonAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.items_layout,
            parent,
            false
        )
        return MyViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listPosition = pokemonList[position]

        with(holder) {
            uiTvName.text = listPosition.name
            uiTvBaseXP.text = "EXPERIENCE:" + listPosition.experience.toString()
            uiTvHeight.text = "HEIGHT:" + listPosition.height.toString()
            uiTvWeight.text = "WEIGHT:" + listPosition.weight.toString()
            Picasso.with(itemView.context)
                .load("https://www.freepnglogos.com/uploads/pokeball-png/pokeball-alexa-style-blog-pokemon-inspired-charmander-daily-8.png")
                //.placeholder(R.drawable.ic_place_holder)
                //.error(R.drawable.ic_place_holder)
                .into(holder.uiIvDisplayImage)

        }
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    fun onListChanged(list: List<Pokemon>) {
        this.pokemonList.clear()
        list.let { this.pokemonList.addAll(it) }
        notifyDataSetChanged()
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var uiTvName: TextView = itemView.findViewById(R.id.uiTvName)
        var uiTvBaseXP: TextView = itemView.findViewById(R.id.uiTvBaseXP)
        var uiTvHeight: TextView = itemView.findViewById(R.id.uiTvHeight)
        var uiTvWeight: TextView = itemView.findViewById(R.id.uiTvWeight)
        var uiIvDisplayImage: ImageView = itemView.findViewById(R.id.uiIvDisplayImage)

        init {
            uiIvDisplayImage.setOnClickListener {
                onItemClick(pokemonList[adapterPosition])
            }
        }
    }
}