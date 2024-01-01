package com.example.week1.ui.contact

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.Gson

class MyItem (val profile: Int, val name: String?, val number: String?, var isFavorite: Boolean): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    fun toggleFavorite() {
        isFavorite = !isFavorite
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(profile)
        parcel.writeString(name)
        parcel.writeString(number)
        parcel.writeByte(if (isFavorite) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MyItem> {
        override fun createFromParcel(parcel: Parcel): MyItem {
            return MyItem(parcel)
        }

        override fun newArray(size: Int): Array<MyItem?> {
            return arrayOfNulls(size)
        }
    }

}