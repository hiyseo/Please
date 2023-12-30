package com.example.week1.ui.contact

class MyItem (val profile: Int, val name: String, val number: String, var isFavorite: Boolean){
    fun toggleFavorite() {
        isFavorite = !isFavorite
    }
}