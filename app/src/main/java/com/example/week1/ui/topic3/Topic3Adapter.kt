package com.example.week1.ui.topic3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week1.databinding.LayoutWeatherListsCloudyBinding
import com.example.week1.databinding.LayoutWeatherListsSunnyBinding

class Topic3Adapter(private val items: Array<Weather>) : RecyclerView.Adapter<Topic3Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            SUNNY_VIEW_TYPE -> {
                val binding = LayoutWeatherListsSunnyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ViewHolder.SunnyViewHolder(binding)
            }
            CLOUDY_VIEW_TYPE -> {
                val binding = LayoutWeatherListsCloudyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ViewHolder.CloudyViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        when (holder) {
            is ViewHolder.SunnyViewHolder -> holder.bindSunny(item)
            is ViewHolder.CloudyViewHolder -> holder.bindCloudy(item)
        }
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int): Int {
        val skyType = items[position].sky
        return when (skyType) {
            "1" -> SUNNY_VIEW_TYPE
            "3", "4" -> CLOUDY_VIEW_TYPE
            else -> throw IllegalArgumentException("Invalid sky type")
        }
    }

    sealed class ViewHolder(itemView: ViewGroup) : RecyclerView.ViewHolder(itemView) {
        class SunnyViewHolder(private val binding: LayoutWeatherListsSunnyBinding) : ViewHolder(binding.root) {
            fun bindSunny(item: Weather) {
                binding.apply {
                    // Bind sunny layout views with item data
                tvTime.text = item.fcstTime.substring(0 until 2) + "시"
                tvRainType.text = getRainType(item.rainType)
                tvHumidity.text = item.humidity + "%"
                tvSky.text = getSky(item.sky)
                tvTemp.text = item.temp + "°"
                }
            }
        }

        class CloudyViewHolder(private val binding: LayoutWeatherListsCloudyBinding) : ViewHolder(binding.root) {
            fun bindCloudy(item: Weather) {
                binding.apply {
                    // Bind cloudy layout views with item data

                    tvTime.text = item.fcstTime.substring(0 until 2) + "시"
                    tvRainType.text = getRainType(item.rainType)
                    tvHumidity.text = item.humidity + "%"
                    tvSky.text = getSky(item.sky)
                    tvTemp.text = item.temp + "°"
                }
            }
        }
    }

    companion object {
        private const val SUNNY_VIEW_TYPE = 1
        private const val CLOUDY_VIEW_TYPE = 2
    }
}



    private fun getRainType(rainType: String): String {
        return when (rainType) {
            "0" -> "강수량 없음"
            "1" -> "비"
            "2" -> "비/눈"
            "3" -> "눈"
            "5" -> "빗방울"
            "6" -> "빗방울/눈날림"
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

