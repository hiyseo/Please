package com.example.week1.ui.contact

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week1.R
import com.example.week1.databinding.ItemRvBinding

class MyAdapter(val items: MutableList<MyItem>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    var favoriteClick: FavoriteClick? = null
    var itemClick: ItemClick? = null

    interface FavoriteClick {
        fun onFavoriteClick(view: View, position: Int)
    }

    interface ItemClick {
        fun onItemClick(view: View, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRvBinding.inflate(inflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)

        holder.itemView.setOnClickListener {
            itemClick?.onItemClick(it, position)
        }

        holder.binding.favorite.setOnClickListener {
            favoriteClick?.onFavoriteClick(it, position)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class MyViewHolder(val binding: ItemRvBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.profile.clipToOutline = true
        }

        fun bind(item: MyItem) {
            binding.apply {
                profile.setImageResource(item.profile)
                name.text = item.name
                number.text = item.number
                favorite.setImageResource(if (item.isFavorite) R.drawable.check_filled else R.drawable.check_empty)
            }
        }
    }

    class AddressAdapterDecoration : RecyclerView.ItemDecoration() {
        override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
            super.onDraw(c, parent, state)

            val paint = Paint()
            paint.color = Color.GRAY

            for (i in 0 until parent.childCount) {
                val child = parent.getChildAt(i)
                val layoutParams = child.layoutParams as RecyclerView.LayoutParams
                val top = (child.bottom + layoutParams.bottomMargin + 40).toFloat()

                val left = parent.paddingStart.toFloat()
                val right = (parent.width - parent.paddingEnd).toFloat()

                val bottom = top + 1f

                c.drawRect(left, top, right, bottom, paint)
            }
        }

        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            super.getItemOffsets(outRect, view, parent, state)
            val offset = 40
            outRect.top = offset
            outRect.bottom = offset
        }
    }
}
