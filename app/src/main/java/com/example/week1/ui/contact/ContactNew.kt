package com.example.week1.ui.contact

import android.app.Activity
import android.content.Intent
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
//    val newitems = items
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_new)
        setTitle("연락처 등록")

        val saveButton = findViewById<Button>(R.id.new_save_btn)
        val nameInput : EditText = findViewById(R.id.new_name_input)
        val phoneInput : EditText = findViewById(R.id.new_phone_input)
//
//        var nameBuffer : String = ""
//        var phoneBuffer : String = ""
//        var emailBuffer : String = ""

//        nameInput.addTextChangedListener(object: TextWatcher {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                nameBuffer = nameInput.text.toString()
//                saveButton.isEnabled = isValid(nameBuffer, phoneBuffer, emailBuffer)
//            }
//            override fun afterTextChanged(p0: Editable?) {}
//        })
//
//        phoneInput.addTextChangedListener(object: TextWatcher {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                phoneBuffer = phoneInput.text.toString().trim()
//                saveButton.isEnabled = isValid(nameBuffer, phoneBuffer, emailBuffer)
//            }
//            override fun afterTextChanged(p0: Editable?) {}
//        })
//        saveButton.setOnClickListener{
//            savePhone(0, nameBuffer, phoneBuffer, false)
//            setResult(Activity.RESULT_OK, data)
//            Toast.makeText(this, "저장되었습니다 !", Toast.LENGTH_SHORT).show()
//            finish()
//        }

//        // '저장' 버튼을 눌렀을 때의 로직
//        saveButton.setOnClickListener {
//            val name = nameInput.text.toString()
//            val phoneNumber = phoneInput.text.toString()
//            val imageResourceId = R.drawable.default_image_profile
//            val isFavorite = false
//
//            // 결과를 Contact Fragment로 보내기
//            val data = Intent(this, ContactFragment::class.java)
//            data.putExtra("profile",imageResourceId)
//            data.putExtra("name", name)
//            data.putExtra("number", phoneNumber)
//            data.putExtra("isFavorite", isFavorite)
//            savePhone(imageResourceId, name, phoneNumber, isFavorite)
//            setResult(Activity.RESULT_OK, data)
//            Toast.makeText(this, "저장되었습니다 !", Toast.LENGTH_SHORT).show()
//            finish()
//        }
//    }

//    private fun savePhone(profile: Int, name : String, number : String, isfavorite : Boolean) {
//        val newItem = MyItem(0, name, number, false)
//        ContactFragment.dataList.add(newItem)
//        adapter.notifyDataSetChanged()
//        finish()
//    }

//    fun isValid(name : String, phone : String) : Boolean {
//        return name.isNotEmpty() and phone.isNotEmpty()
    }

}
