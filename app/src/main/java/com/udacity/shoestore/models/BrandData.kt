package com.udacity.shoestore.models
import androidx.annotation.DrawableRes


data class BrandData(val brandName:String,@DrawableRes val brandRes:Int){
//    private fun getBrandByName(): BrandData{
//        return DefaultShoeList.brandList.first{
//            it.brandName == this.brandName
//        }
//    }
}
