package com.example.week1.ui.contact

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.week1.R

class ContactDetail : AppCompatActivity() {
    private var index : Int = -1
    private lateinit var item : MyItem
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_detail)
        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val profile = intent.getIntExtra("profile", 0)
        val favorite = intent.getBooleanExtra("favorite",false)
        val position = intent.getIntExtra("position",0)

        for (i in 0 until ContactFragment.itemList.size) {
            if (ContactFragment.itemList[i].name == name) {
                index = i
                item = ContactFragment.itemList[index]
            }
        }

        setTitle("'$name' 연락처 상세")
        val deleteBtn : Button = findViewById(R.id.detail_delete_btn)
        val EditButton = findViewById<Button>(R.id.detail_edit_btn)
        val nameInput : EditText = findViewById(R.id.detail_name_input)
        val phoneInput : EditText = findViewById(R.id.detail_phone_input)
        val imageView : ImageView = findViewById(R.id.profile)

        nameInput.setText("$name")
        phoneInput.setText("$phone")
        val profileResourceName = "${profile}" // 예: "image_profile1"
        val resourceId = resources.getIdentifier(profileResourceName, "drawable", packageName)

        if (resourceId != 0) {
            imageView.setImageResource(resourceId)
        } else {
            imageView.setImageResource(R.drawable.default_image_profile)
        }

        val CallButton = findViewById<Button>(R.id.call_btn)
        CallButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone"))
            startActivity(intent)
        }

        // '수정' 버튼을 눌렀을 때의 로직
        EditButton.setOnClickListener {
            val name = name
            val phone = phone
            val newname = findViewById<EditText>(R.id.detail_name_input).text.toString()
            val newphoneNumber = findViewById<EditText>(R.id.detail_phone_input).text.toString()
            val profileImage = profile
            val isFavorite = favorite
            val insertposition = position
            val intent = Intent()
            intent.putExtra("action","edit")
            intent.putExtra("oriname", name)
            intent.putExtra("newname",newname)
            intent.putExtra("oriphone", phone)
            intent.putExtra("newphone", newphoneNumber)
            intent.putExtra("profile", profileImage)
            intent.putExtra("favorite", isFavorite)
            intent.putExtra("position", insertposition)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        deleteBtn.setOnClickListener {
            val positionToRemove = position
            val intent = Intent()
            intent.putExtra("action", "delete")
            intent.putExtra("positionToRemove", positionToRemove)
            setResult(RESULT_OK,intent)
            finish()
        }

    }


}