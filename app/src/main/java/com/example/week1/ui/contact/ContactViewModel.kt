package com.example.week1.ui.contact

import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContactViewModel : ViewModel() {

    private val _dataList = MutableLiveData<List<MyItem>>()
    val dataList: LiveData<List<MyItem>> = _dataList


//
//    private val _text = MutableLiveData<String>().apply {
//        value = "연락처"
//    }
//
//    val text: LiveData<String> = _text

}