package com.example.week1.ui.images

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.week1.R

class PhotoIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_in)

        val photo = intent.getParcelableExtra<Photo>("photo")
        if(photo != null){
            val imageView : ImageView = findViewById(R.id.photoIn)

            imageView.setImageResource(photo.image)
        }
    }
}