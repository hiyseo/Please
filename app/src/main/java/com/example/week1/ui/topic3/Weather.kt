package com.example.week1.ui.topic3

data class Weather(var rainType: String = "",       // 강수 형태
                   var humidity: String = "",       // 습도
                   var sky: String = "",            // 하능 상태
                   var temp: String = "",           // 기온
                   var fcstTime: String = ""       // 예보시각
                    )
