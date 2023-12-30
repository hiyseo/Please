package com.example.week1.ui.topic3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Topic3ViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "자유주제"
    }
    val text: LiveData<String> = _text
}