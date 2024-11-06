package com.example.tugasgaleri

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tugasgaleri.databinding.ItemImageBinding

class ImageAdapter (private val ListImage:List<Image>):RecyclerView.Adapter<ImageAdapter.ItemImageViewHolder>(){

    inner class ItemImageViewHolder
        (private val binding: ItemImageBinding):RecyclerView.ViewHolder(binding.root){
            fun bind(data:Image){
                with(binding){

                    val imageUrl = data.source

                    Glide.with(binding.root.context)
                        .load(imageUrl)
                        .into(binding.imageHolder)

                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemImageViewHolder {
        val binding = ItemImageBinding.inflate(
            LayoutInflater.from(parent.context)
            , parent,false)
        return  ItemImageViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return ListImage.size
    }

    override fun onBindViewHolder(holder: ItemImageViewHolder, position: Int) {
        holder.bind(ListImage[position])
    }


}