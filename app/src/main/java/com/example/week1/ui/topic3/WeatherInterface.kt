package com.example.week1.ui.topic3

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherInterface {

    @GET("getUltraSrtFcst?serviceKey=IviIIfUtmdUfhOntjNvAUlbwN63XAA2TxkcoMkYlKqui%2FRxBkwmG%2B1%2FJ3Hi3eW9A13n6xZRDPsaLKwaKGcA%2F1A%3D%3D")

    fun GetWeather(@Query("numOfRows") num_of_rows : Int,
                   @Query("pageNo") page_no : Int,
                   @Query("dataType") data_type : String,
                   @Query("base_date") base_date : String,
                   @Query("base_time") base_time : String,
                   @Query("nx") nx : String,
                   @Query("ny") ny : String)
            : Call<WeatherApi>
}


private val retrofit = Retrofit.Builder()
    .baseUrl("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

object ApiObject {
    val retrofitService: WeatherInterface by lazy {
        retrofit.create(WeatherInterface::class.java)
    }
}