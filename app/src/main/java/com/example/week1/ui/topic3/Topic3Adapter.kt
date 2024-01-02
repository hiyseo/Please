package com.example.week1.ui.topic3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week1.databinding.LayoutWeatherListsBinding

class Topic3Adapter(private val items: Array<Weather>) : RecyclerView.Adapter<Topic3Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutWeatherListsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(private val binding: LayoutWeatherListsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Weather) {
            binding.apply {
                tvTime.text = item.fcstTime.substring(0 until 2) + "시"
                tvRainType.text = getRainType(item.rainType)
                tvHumidity.text = item.humidity
                tvSky.text = getSky(item.sky)
                tvTemp.text = item.temp + "°"
            }
        }
    }

    private fun getRainType(rainType: String): String {
        return when (rainType) {
            "0" -> "없음"
            "1" -> "비"
            "2" -> "비/눈"
            "3" -> "눈"
            "5" -> "빗방울"
            "6" -> "빗방울눈날림"
            "7" -> "눈날림"
            else -> "오류 rainType : $rainType"
        }
    }

    private fun getSky(sky: String): String {
        return when (sky) {
            "1" -> "맑음"
            "3" -> "구름 많음"
            "4" -> "흐림"
            else -> "오류 rainType : $sky"
        }
    }
}
