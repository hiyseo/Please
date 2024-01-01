package com.example.week1.ui.images

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.week1.R

//class RecyclerViewPhotoAdapter constructor(private val getActivity: MainActivity, private val photoList : List<Photo>) :
class RecyclerViewPhotoAdapter (val items: MutableList<Photo>) : RecyclerView.Adapter<RecyclerViewPhotoAdapter.MyViewHolder>()
{

    var onItemClick : ((Photo) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerViewPhotoAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_photo_lists, parent, false)

        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerViewPhotoAdapter.MyViewHolder, position: Int) {
        val photo = items[position]
        holder.photoName.text = items[position].name
        holder.ivPhotoImage.setImageResource(items[position].image)

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(photo)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photoName : TextView = itemView.findViewById(R.id.photoName)
        val ivPhotoImage :ImageView = itemView.findViewById(R.id.ivPhotoImage)
        val cardView : CardView = itemView.findViewById(R.id.cardView)

    }

}