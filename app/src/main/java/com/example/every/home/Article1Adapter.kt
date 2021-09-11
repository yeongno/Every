package com.example.every.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.every.databinding.ItemHomearticle1Binding
import java.text.SimpleDateFormat
import java.util.*

class Article1Adapter: androidx.recyclerview.widget.ListAdapter<Article1Model, Article1Adapter.ViewHolder>(diffUTil) {

    inner class ViewHolder(private val binding: ItemHomearticle1Binding): RecyclerView.ViewHolder(binding.root){

        fun bind(article1Model: Article1Model){
            val format = SimpleDateFormat("MM월 dd일")
            val date = Date(article1Model.createdAt)

            binding.nameTextView.text = article1Model.title
            binding.editTitleView.text = format.format(date).toString()
            binding.dataTextView.text = article1Model.data

            if(article1Model.imageUrl.isNotEmpty())
            Glide.with(binding.thumbnailImageView)
                .load(article1Model.imageUrl)
                .into(binding.thumbnailImageView)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemHomearticle1Binding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object  {
        val diffUTil = object : DiffUtil.ItemCallback<Article1Model>(){
            override fun areItemsTheSame(oldItem: Article1Model, newItem: Article1Model): Boolean {
                return oldItem.createdAt == newItem.createdAt
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: Article1Model, newItem: Article1Model): Boolean {
                return oldItem == newItem
            }

        }
    }

}