package com.example.clase5onitemselected

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

//import com.bumptech.glide.Glide

class PokemonAdapter(val context: Context) : ListAdapter<Pokemon, PokemonAdapter.ViewHolder>(DiffCallBack) {

    lateinit var onItemClickListener: (Pokemon) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val name: TextView = view.findViewById(R.id.textViewName)
        private val life : TextView = view.findViewById(R.id.textViewLife)
        private val attack: TextView = view.findViewById(R.id.textViewStrength)
        private val defense: TextView = view.findViewById(R.id.textViewDefense)
        private val imageType: ImageView = view.findViewById(R.id.imageViewType)
        private val imagePokemon: ImageView = view.findViewById(R.id.imageViewPhoto)

        fun  bind (pokemon: Pokemon) {
            //De ese Text View el texto que sea como se indica debajo:
            name.text = "nombre: " + pokemon.name
            life.text = "vida " + pokemon.life.toString() // .toString(), porque es un tipo de dato INT
            attack.text = "ataque: " + pokemon.attack.toString()  // .toString(), porque es un tipo de dato INT
            defense.text = "defensa: " + pokemon.defense.toString()  // .toString(), porque es un tipo de dato INT

            val image = when(pokemon.type) {
                PokemonType.WATER -> R.drawable.agua
                PokemonType.ELECTRIC -> R.drawable.electrico
                PokemonType.FIGHT -> R.drawable.fighter
                PokemonType.PLANT -> R.drawable.planta
                PokemonType.FIRE -> R.drawable.fuego
            }

            imageType.setImageResource(image)

            //Traigo la imagen de la URL con GLIDE
            Glide.with(context)
                .load(pokemon.url)
                .into(imagePokemon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonAdapter.ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonAdapter.ViewHolder, position: Int) {
        val pokemon = getItem(position)
        holder.bind(pokemon)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem
        }
    }
}