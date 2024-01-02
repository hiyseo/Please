package com.example.week1.ui.contact

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.week1.R

class ContactNew: AppCompatActivity() {
    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_new)
        setTitle("연락처 등록")

        val saveButton = findViewById<Button>(R.id.new_save_btn)
        val nameInput: EditText = findViewById(R.id.new_name_input)
        val phoneInput: EditText = findViewById(R.id.new_phone_input)
        saveButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("name",nameInput.text.toString())
            intent.putExtra("phone", phoneInput.text.toString())
            intent.putExtra("profile", 0)
            intent.putExtra("favorite", false)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
