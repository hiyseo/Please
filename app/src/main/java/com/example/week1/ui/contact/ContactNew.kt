package com.example.week1.ui.contact

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.week1.R

class ContactNew : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_new)

        setTitle("연락처 등록")

        // '저장' 버튼을 눌렀을 때의 로직
        val saveButton = findViewById<Button>(R.id.new_save_btn)
//        val descriptionEditText = findViewById<EditText>(R.id.descriptionEditText)

        saveButton.setOnClickListener {
            val name = findViewById<EditText>(R.id.new_name_input).text.toString()
            val phoneNumber = findViewById<EditText>(R.id.new_phone_input).text.toString()
            val profileImage = R.drawable.image_profile1
            val isFavorite = false
//            val description = descriptionEditText.text.toString()

            // 결과를 Contact Fragment로 보내기
            val data = Intent(this, ContactFragment::class.java)
            data.putExtra("profileImage",profileImage)
            data.putExtra("name", name)
            data.putExtra("phoneNumber", phoneNumber)
            data.putExtra("isFavorite", isFavorite)

            setResult(Activity.RESULT_OK, data)
            Toast.makeText(this, "저장되었습니다 !", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
