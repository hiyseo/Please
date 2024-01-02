package com.example.week1.ui.contact

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.week1.R
import com.example.week1.databinding.ItemRvBinding

class MyAdapter (val items: MutableList<MyItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var favoriteClick: FavoriteClick? = null
    var itemClick: ItemClick? = null
    companion object {
        private const val VIEW_TYPE_DEFAULT = 0
        private const val VIEW_TYPE_ANOTHER = 1
    }
    interface FavoriteClick {
        fun onFavoriteClick(view: View, position: Int)
    }
    interface ItemClick{
        fun onItemClick(view: View, position: Int)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //뷰 홀더를 생성하고 레이아웃을 인플레이트
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_DEFAULT -> {
                val binding = ItemRvBinding.inflate(inflater, parent, false)
                DefaultViewHolder(binding)
            }
            VIEW_TYPE_ANOTHER -> {
                val binding = ItemRvBinding.inflate(inflater, parent, false)
                AnotherViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //뷰 홀더에 데이터를 바인딩
        val item = items[position]
        when (holder) {
            is DefaultViewHolder -> holder.bindDefault(item)
            is AnotherViewHolder -> holder.bindAnother(item)
        }
        holder.itemView.setOnClickListener{
            itemClick?.onItemClick(it, position)
        }
        holder.itemView.findViewById<ImageView>(R.id.favorite).setOnClickListener {
            favoriteClick?.onFavoriteClick(it, position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position].isFavorite) {
            VIEW_TYPE_DEFAULT
        } else {
            VIEW_TYPE_ANOTHER
        }
    }

    override fun getItemCount(): Int {
        //어댑터가 가진 아이템의 개수 반환
        return items.size
    }

    inner class DefaultViewHolder(private val binding: ItemRvBinding) : RecyclerView.ViewHolder(binding.root) {
        private val profile = binding.profile
        private val name = binding.name
        private val number = binding.number
        private val favorite = binding.favorite
        init {
            profile.clipToOutline = true
        }
        fun bindDefault(item: MyItem) {
            profile.setImageResource(item.profile)
            name.text = item.name
            number.text = item.number
            favorite.setImageResource(if (item.isFavorite) R.drawable.check_filled else R.drawable.check_empty)
        }
    }

    inner class AnotherViewHolder(private val binding: ItemRvBinding) : RecyclerView.ViewHolder(binding.root) {
        private val profile = binding.profile
        private val name = binding.name
        private val number = binding.number
        private val favorite = binding.favorite
        init {
            profile.clipToOutline = true
        }
        fun bindAnother(item: MyItem) {
            profile.setImageResource(item.profile)
            name.text = item.name
            number.text = item.number
            favorite.setImageResource(if (item.isFavorite) R.drawable.check_filled else R.drawable.check_empty)
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