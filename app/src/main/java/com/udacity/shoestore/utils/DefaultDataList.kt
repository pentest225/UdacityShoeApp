package com.udacity.shoestore.utils

import com.udacity.shoestore.R
import com.udacity.shoestore.models.BrandData
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeSizeData

object DefaultDataList {
    val shoeList = mutableListOf<Shoe>(
        Shoe(name = "Men's Air Max SC Sneaker",
            smallDescription = "Get an old school look in the Men's Nike Air Max SC Sneaker.",
            description = "Get an old school look in the Men's Nike Air Max SC Sneaker.\n" +
                "\n" +
                "Leather, textile and mesh upper in a fashion sneaker style with a round toe\n" +
                "Lace-up closure\n" +
                "Padded collar and tongue for increased comfort\n" +
                "Soft lining with cushioned insole\n" +
                "Foam midsole with Max Air unit at heel\n" +
                "Durable rubber outsole",
            company = "NIKE", size = 2.1,
            isNewCollection = true,
            images = listOf(
                "https://images.unsplash.com/photo-1491553895911-0055eca6402d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8c2hvZXMlMjBuaWtlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
                ), price = "124"),
        Shoe(
            name = "Women's Asher Slip On Sneaker",
            smallDescription = "Stay casual and cool in the Vans Women's Asher Slip On Sneaker",
            description = "Stay casual and cool in the Vans Women's Asher Slip On Sneaker.\n" +
                "\n" +
                "Canvas or leather upper in an athletic slip-on skate style\n" +
                "Twin elastic goring panels ensure a secure fit\n" +
                "Padded collar\n" +
                "Textile lining with a cushioning footbed\n" +
                "Striped, rubber midsole\n" +
                "Grippy rubber outsole\n",
            isNewCollection = true,
            company = "VanS", size = 2.1,
            images = listOf(
                "https://images.unsplash.com/photo-1605348532760-6753d2c43329?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8c2hvZXMlMjBuaWtlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
                ),price = "124"),
        Shoe(
            name = "Men's Ward Low Top Sneaker",
            smallDescription = "Side stripe style goes for miles in the Ward Low Top Sneaker from Vans",
            description = "Side stripe style goes for miles in the Ward Low Top Sneaker from Vans.\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Suede or canvas upper in a low top skate sneaker style with a round toe\n" +
                    "\n" +
                    "Lace up closure\n" +
                    "\n" +
                    "Padded collar for extra comfort\n" +
                    "\n" +
                    "Side stripe detail\n" +
                    "\n" +
                    "Smooth lining, cushioning insole\n" +
                    "\n" +
                    "Vulcanized rubber outsole",
            company = "VanS", size = 2.1,
            images = listOf(
                "https://images.unsplash.com/photo-1600269452121-4f2416e55c28?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8N3x8c2hvZXMlMjBuaWtlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",

                ),price = "124"),
    )

    val brandList = listOf(
        BrandData("Nike", R.drawable.nike_brands),
        BrandData("Adidas", R.drawable.adidas_brand),
        BrandData("Balenciaga", R.drawable.balenciaga_brand),
        BrandData("Vans", R.drawable.vans_brand),
    )

    val sizeList = mutableListOf<ShoeSizeData>(
        ShoeSizeData("37"),
        ShoeSizeData("38"),
        ShoeSizeData("39"),
        ShoeSizeData("40", isSelected = true),
        ShoeSizeData("41"),
        ShoeSizeData("42"),
        ShoeSizeData("43"),
        ShoeSizeData("44"),
    )
}