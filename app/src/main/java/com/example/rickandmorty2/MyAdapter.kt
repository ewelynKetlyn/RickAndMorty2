package com.example.rickandmorty2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmorty2.databinding.RickAndMortyItemBinding
import com.example.rickandmorty2.model.Character

class MyAdapter(val myList: List<Character>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    class MyViewHolder(val binding: RickAndMortyItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(character: Character) {
            binding.tvName.text = character.name
            binding.tvSpecie.text = character.species
            Glide.with(binding.ivCharacter).load(character.image).into(binding.ivCharacter)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RickAndMortyItemBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(myList[position])
    }

    override fun getItemCount(): Int {
        return myList.size
    }

}