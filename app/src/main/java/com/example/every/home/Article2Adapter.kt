package com.example.every.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.every.databinding.ItemHomearticle1Binding
import com.example.every.databinding.ItemHomearticle2Binding
import java.text.SimpleDateFormat
import java.util.*

class Article2Adapter: androidx.recyclerview.widget.ListAdapter<Article2Model, Article2Adapter.ViewHolder>(diffUTil) {

    inner class ViewHolder(private val binding: ItemHomearticle2Binding): RecyclerView.ViewHolder(binding.root){

        fun bind(article2Model: Article2Model){
            val format = SimpleDateFormat("MM월 dd일")
            val date = Date(article2Model.createdAt)

            binding.dateTextView.text = format.format(date).toString()
            binding.dataTextView.text = article2Model.data

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemHomearticle2Binding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object  {
        val diffUTil = object : DiffUtil.ItemCallback<Article2Model>(){
            override fun areItemsTheSame(oldItem: Article2Model, newItem: Article2Model): Boolean {
                return oldItem.createdAt == newItem.createdAt
            }

            override fun areContentsTheSame(oldItem: Article2Model, newItem: Article2Model): Boolean {
                return oldItem == newItem
            }

        }
    }

}