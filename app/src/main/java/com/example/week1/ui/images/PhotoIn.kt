package com.example.week1.ui.images

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.week1.R

class PhotoIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_in)

        val photo = intent.getParcelableExtra<Photo>("photo")
        val backButton = findViewById<Button>(R.id.buttonBack)

        backButton?.setOnClickListener {
            finish()
        }

        if(photo != null){
            val imageView : ImageView = findViewById(R.id.photoIn)
            val textView : TextView = findViewById(R.id.textIn)
            textView.text = photo.name
            imageView.setImageResource(photo.image)
        }

    }
}