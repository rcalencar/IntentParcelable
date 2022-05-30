package com.rcalencar.intentparcelable

import android.os.Parcel
import android.os.Parcelable

data class UserParcelableData(val name: String, val address: List<String>) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.createStringArrayList()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeStringList(address)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserParcelableData> {
        override fun createFromParcel(parcel: Parcel): UserParcelableData {
            return UserParcelableData(parcel)
        }

        override fun newArray(size: Int): Array<UserParcelableData?> {
            return arrayOfNulls(size)
        }
    }
}