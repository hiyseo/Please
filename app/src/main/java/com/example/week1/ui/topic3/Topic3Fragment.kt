package com.example.week1.ui.topic3

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week1.databinding.FragmentNotificationsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class Topic3Fragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    lateinit var weatherRecyclerView: RecyclerView

    private var base_date = "20240102"
    private var base_time = "1400"
    private var nx = "66"
    private var ny = "101"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val tvDate = binding.tvDate
        weatherRecyclerView = binding.weatherRecyclerView
        val btnRefresh = binding.btnRefresh

        weatherRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        tvDate.text = SimpleDateFormat("MM월 dd일 ", Locale.getDefault()).format(Calendar.getInstance().time) + "날씨"

        setWeather(nx, ny)

        btnRefresh.setOnClickListener {
            setWeather(nx, ny)
        }
        return root
    }
    private fun setWeather(nx : String, ny : String) {
        val cal = Calendar.getInstance()
        base_date = SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(cal.time)
        val timeH = SimpleDateFormat("HH", Locale.getDefault()).format(cal.time)
        val timeM = SimpleDateFormat("HH", Locale.getDefault()).format(cal.time)
        base_time = getBaseTime(timeH, timeM)
        if (timeH == "00" && base_time == "2330") {
            cal.add(Calendar.DATE, -1).toString()
            base_date = SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(cal.time)
        }

        val call = ApiObject.retrofitService.GetWeather(60, 1, "JSON", base_date, base_time, nx, ny)

        call.enqueue(object : Callback<WeatherApi> {
            override fun onResponse(call: Call<WeatherApi>, response: Response<WeatherApi>) {
                if (response.isSuccessful) {
                    val it: List<WeatherApi.Item> = response.body()!!.response.body.items.item

                    val weatherArr = arrayOf(Weather(), Weather(), Weather(), Weather(), Weather(), Weather())

                    var index = 0
                    val totalCount = response.body()!!.response.body.totalCount -1
                    for (i in 0..totalCount) {
                        index %= 6
                        when(it[i].category) {
                            "PTY" -> weatherArr[index].rainType = it[i].fcstValue     // 강수 형태
                            "REH" -> weatherArr[index].humidity = it[i].fcstValue     // 습도
                            "SKY" -> weatherArr[index].sky = it[i].fcstValue          // 하늘 상태
                            "T1H" -> weatherArr[index].temp = it[i].fcstValue         // 기온
                            else -> continue
                        }
                        index++
                    }

                    for (i in 0..5) weatherArr[i].fcstTime = it[i].fcstTime.toString()

                    weatherRecyclerView.adapter = Topic3Adapter(weatherArr)

                    Toast.makeText(requireContext(), "${it[0].fcstDate}, ${it[0].fcstTime.toString().substring(0 until 2) }시의 날씨 정보입니다.", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<WeatherApi>, t: Throwable) {
                val tvError = binding.tvError
                tvError.text = "api fail : " +  t.message.toString() + "\n 다시 시도해주세요."
                tvError.visibility = View.VISIBLE
                Log.d("api fail", t.message.toString())
            }
        })
    }
    private fun getBaseTime(h : String, m : String) : String {
        var result = ""

        if (m.toInt() < 45) {
            if (h == "00") result = "2330"
            else {
                var resultH = h.toInt() - 1
                if (resultH < 10) result = "0" + resultH + "30"
                else result = resultH.toString() + "30"
            }
        }
        else result = h + "30"

        return result
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}