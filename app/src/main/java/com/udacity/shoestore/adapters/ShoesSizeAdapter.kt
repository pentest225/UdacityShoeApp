package com.udacity.shoestore.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.udacity.shoestore.R
import com.udacity.shoestore.models.ShoeSizeData

class ShoesSizeAdapter(private val sizeList:List<ShoeSizeData>, val onSelect:(selectedSize:ShoeSizeData)->Unit) :RecyclerView.Adapter<ShoesSizeAdapter.ShoesSizeViewHolder>(){

    inner class ShoesSizeViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tvShoesSize : TextView = view.findViewById(R.id.tvShoesSize)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoesSizeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shoes_size,parent,false)
        return ShoesSizeViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoesSizeViewHolder, position: Int) {
        val selectedShoe = sizeList[position]
        holder.tvShoesSize.text = selectedShoe.size
//        if(selectedShoe.isSelected){
//            holder.tvShoesSize.setBackgroundResource(R.drawable.shape_shoe_size)
//        }else{
//            holder.tvShoesSize.setBackgroundResource(R.drawable.shape_shoe_size)
//        }
        holder.tvShoesSize.setOnClickListener {
            onSelect(selectedShoe)
        }

    }

    override fun getItemCount() = sizeList.size
}