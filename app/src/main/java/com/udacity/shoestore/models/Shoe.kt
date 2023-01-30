package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(
    var name: String,
    var size: Double,
    var company: String,
    var description: String,
    var smallDescription : String = "",
    var price : String,
    val isNewCollection : Boolean = false,
    val images: List<String> = mutableListOf()
) : Parcelable
