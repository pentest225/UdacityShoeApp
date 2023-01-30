package com.udacity.shoestore.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe

class ShoesItemAdapter(private val shoeList:List<Shoe>,val layout:Int, val onSelectItem:(shoe:Shoe)->Unit):RecyclerView.Adapter<ShoesItemAdapter.ShoesViewHolder>() {
    inner class ShoesViewHolder(view: View):RecyclerView.ViewHolder(view){
        val shoeImage : ImageView = view.findViewById(R.id.imShoe)
        val shoeTitle : TextView = view.findViewById(R.id.tvShowTitle)
        val shoeDescription : TextView? = view.findViewById(R.id.tvShowDescription)
        val shoePrice : TextView = view.findViewById(R.id.tvShowPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layout,parent,false)
        return ShoesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoesViewHolder, position: Int) {
        val selectedShoe = shoeList[position]
        holder.shoeTitle.text = selectedShoe.name
        holder.shoeDescription?.text = selectedShoe.smallDescription
        holder.shoePrice.text = selectedShoe.price
        holder.shoeImage.load(selectedShoe.images.first()){
            placeholder(R.drawable.default_shoes)
            transformations(CircleCropTransformation())
        }
    }

    override fun getItemCount() = shoeList.size
}