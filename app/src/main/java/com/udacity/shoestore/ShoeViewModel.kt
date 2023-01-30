package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeSizeData
import com.udacity.shoestore.utils.DefaultDataList
import timber.log.Timber

class ShoeViewModel : ViewModel() {
        private val _mokShoeList : MutableList<Shoe> = DefaultDataList.shoeList
        private val _mokShoeSizeList : MutableList<ShoeSizeData> = DefaultDataList.sizeList
        private val _shoesAddedImages : MutableList<String> = mutableListOf()

        private var _shoesLiveData : MutableLiveData<MutableList<Shoe>> = MutableLiveData<MutableList<Shoe>>()
        private var _shoeSize : MutableLiveData<MutableList<ShoeSizeData>> = MutableLiveData<MutableList<ShoeSizeData>>()
        val shoeSizeList : LiveData<MutableList<ShoeSizeData>> get() =  _shoeSize
        private var _addEdShoesLink : MutableLiveData<MutableList<String>> = MutableLiveData()
        val addedShoeLink : LiveData<MutableList<String>> get() = _addEdShoesLink
        val shoeList : LiveData<MutableList<Shoe>> = _shoesLiveData

        init {
            _shoeSize.value = _mokShoeSizeList
            _shoesLiveData.value = _mokShoeList
        }

        fun addNewShow(shoe: Shoe){
                _mokShoeList.add(0,shoe)
                _shoesLiveData.value = _mokShoeList
        }

        fun deleteShoeList(imageLink:String){
               _shoesAddedImages.remove(imageLink)
                _addEdShoesLink.value = _shoesAddedImages
        }

        fun addShoeImage(image:String){
                _shoesAddedImages.add(image)
                _addEdShoesLink.value = _shoesAddedImages

        }
}