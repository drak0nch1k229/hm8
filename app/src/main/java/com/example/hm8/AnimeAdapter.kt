package com.example.hm8

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.hm8.databinding.ItemAnimeBinding

class AnimeAdapter(private var list: ArrayList<Anime>, private var onItemClick:(anime:Anime)->Unit) : Adapter<AnimeAdapter.AnimeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        return AnimeViewHolder(ItemAnimeBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class AnimeViewHolder(private var binding: ItemAnimeBinding) : ViewHolder (binding.root){
    fun bind(anime: Anime){
        binding.name.text = anime.title
        binding.lastName.text = anime.description
        Glide.with(binding.imgAni).load(anime.img).into(binding.imgAni)
        itemView.setOnClickListener {
            onItemClick(anime)
        }
    }
    }
}