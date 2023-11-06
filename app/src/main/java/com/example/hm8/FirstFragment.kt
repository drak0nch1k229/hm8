package com.example.hm8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.hm8.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var animeAdapter: AnimeAdapter
    private var list = ArrayList<Anime>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        animeAdapter = AnimeAdapter(list,this:: onClick )
        binding.rv1.adapter = animeAdapter

    }

    private fun loadData() {
        list.add(Anime("https://avatanplus.com/files/resources/original/58c3d2f380dc715abcf00748.png", "Natsu", "Fire Dragon Slayer"))
        list.add(Anime("https://png.monster/wp-content/uploads/2022/09/png.monster-107.png", "Naruto", "Hokage"))
        list.add(Anime("https://freepngimg.com/save/120346-piece-anime-one-free-download-png-hd/1730x862", "Luffy", "Pirates"))
        list.add(Anime("https://freepngimg.com/save/120085-hero-academia-my-hq-image-free/551x613", "Deku", "Student"))
        list.add(Anime("https://img1.picmix.com/output/stamp/normal/0/3/4/5/185430_7ea7f.png", "Erza", "Warrior"))
        list.add(Anime("https://static.wikia.nocookie.net/monster-strike-enjp/images/0/03/4664.png/revision/latest?cb=20200317165030", "Gajeel", "Iron Dragon Slayer"))
        list.add(Anime("https://otakuruma.com/cdn/shop/products/naofumiResize.png?v=1648408259", "Naofumi", "Hero"))
    }
    fun onClick(anime: Anime){
        findNavController().navigate(R.id.secondFragment, bundleOf("key" to anime))
    }

}