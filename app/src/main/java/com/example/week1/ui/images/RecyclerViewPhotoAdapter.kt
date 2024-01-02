package com.example.week1.ui.images

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week1.databinding.LayoutPhotoListsBinding

class RecyclerViewPhotoAdapter(private val items: MutableList<Photo>) :
    RecyclerView.Adapter<RecyclerViewPhotoAdapter.MyViewHolder>() {

    var onItemClick: ((Photo) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = LayoutPhotoListsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val photo = items[position]
        holder.bind(photo)
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(photo)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class MyViewHolder(private val binding: LayoutPhotoListsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: Photo) {
            binding.photoName.text = photo.name
            binding.ivPhotoImage.setImageResource(photo.image)
        }
    }
}
