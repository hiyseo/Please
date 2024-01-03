package com.example.week1

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.os.Handler
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.week1.MainActivity

class SplashActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView((R.layout.activity_splash))

        supportActionBar?.hide()

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(Runnable{
            Intent(this, MainActivity::class.java).apply {
                startActivity(this)
                finish()
            }
        }, 3300)
    }
}