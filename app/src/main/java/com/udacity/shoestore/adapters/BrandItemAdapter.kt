package com.udacity.shoestore.adapters
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.udacity.shoestore.R
import com.udacity.shoestore.models.BrandData

class BrandItemAdapter(context :Context,private val brandList:List<BrandData>):ArrayAdapter<BrandData>(context,0,brandList) {
    private var layoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view : View = layoutInflater.inflate(R.layout.item_brand,null,true)
        return getView(view,position)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        var cv = convertView
        if(cv == null){
            cv =   layoutInflater.inflate(R.layout.item_brand,null,true)
        }
        return getView(cv!!,position)
    }


    private fun getView( view:View,position: Int):View {
        val selectedBrand = brandList[position]
        val brandName = view.findViewById<TextView>(R.id.tvBrandName)
        val brandImage = view.findViewById<ImageView>(R.id.imBrand)
        brandName.text = selectedBrand.brandName
        brandImage.setImageResource(selectedBrand.brandRes)
        return view
    }

}


