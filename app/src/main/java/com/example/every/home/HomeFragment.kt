package com.example.every.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.every.R
import com.example.every.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var binding: FragmentHomeBinding? = null
    private lateinit var article1Adapter: Article1Adapter
    private lateinit var article2Adapter: Article2Adapter



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val fragmentHomeBinding = FragmentHomeBinding.bind(view)
        binding = fragmentHomeBinding


        article1Adapter = Article1Adapter()
        article1Adapter.submitList(mutableListOf<Article1Model>().apply{
            add(Article1Model("0","aaaa",1000000, "5000원",""))
            add(Article1Model("0","aaaa",1000000, "5000원",""))
            add(Article1Model("0","aaaa",1000000, "5000원",""))
            add(Article1Model("0","aaaa",1000000, "5000원",""))
            add(Article1Model("0","aaaa",1000000, "5000원",""))
        })

        article2Adapter = Article2Adapter()
        article2Adapter.submitList(mutableListOf<Article2Model>().apply{
            add(Article2Model("0",1000000))
            add(Article2Model("0",1000000))
            add(Article2Model("0",1000000))

        })

        fragmentHomeBinding.articleLayout.layoutManager = LinearLayoutManager(context)
        fragmentHomeBinding.articleLayout.adapter = article1Adapter
        fragmentHomeBinding.articleLayoutT2.layoutManager = LinearLayoutManager(context)
        fragmentHomeBinding.articleLayoutT2.adapter = article2Adapter


    }



}

