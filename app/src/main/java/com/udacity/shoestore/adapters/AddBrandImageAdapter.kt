package com.udacity.shoestore.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.udacity.shoestore.R

class AddShoesImageAdapter(private val imageList:List<String>,val onDelete:(imageLink:String)->Unit):RecyclerView.Adapter<AddShoesImageAdapter.AddImageShoesViewHolder>() {
    inner class AddImageShoesViewHolder(view: View): RecyclerView.ViewHolder(view){
        val shoeImage : ImageView = view.findViewById(R.id.imAddShoe)
        val deleteCard : ImageButton = view.findViewById(R.id.imDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddImageShoesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shoes_image,parent,false)
        return AddImageShoesViewHolder(view)
    }

    override fun onBindViewHolder(holder: AddImageShoesViewHolder, position: Int) {
        val selectedImage = imageList[position]

        holder.shoeImage.load(selectedImage){
            placeholder(R.drawable.loading)
            transformations(CircleCropTransformation())
        }
        holder.deleteCard.setOnClickListener {
            onDelete(selectedImage)
        }
    }

    override fun getItemCount() = imageList.size
}