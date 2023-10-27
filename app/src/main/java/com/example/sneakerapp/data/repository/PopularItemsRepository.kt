package com.example.sneakerapp.data.repository

import android.content.Context
import com.example.sneakerapp.utils.readJSONFromAssets
import com.example.sneakerapp.view.model.ProductItems
import com.google.gson.Gson

class PopularItemsRepository {
    fun getPopularItemsData(context: Context): ProductItems {
        val jsonString = readJSONFromAssets(context, "list_data.json")
        val data = Gson().fromJson(jsonString, ProductItems::class.java)
        return data
    }
}