package com.example.rickandmorty2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty2.R
import com.example.rickandmorty2.databinding.ItemListBinding
import com.example.rickandmorty2.model.Character
import com.squareup.picasso.Picasso

class CharacterAdapter: RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private var listCharacter = emptyList<Character>()

    class CharacterViewHolder(private val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(character: Character){
            binding.txtIdCharacter.text = character.id.toString()
            binding.txtNameCharacter.text = character.name
            Picasso.get().load(character.image).into(binding.characterImg)
            binding.txtStatus.text = character.status

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemListBinding.inflate(layoutInflater, parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(listCharacter[position])
        holder.itemView.setOnClickListener {view ->
            view.findNavController().navigate(R.id.action_listFragment_to_detailFragment)
        }
    }

    override fun getItemCount(): Int {
        return listCharacter.size
    }

    fun setCharacter(character: List<Character>){
        listCharacter = character
        notifyDataSetChanged()
    }
}