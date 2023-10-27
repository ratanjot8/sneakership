package com.example.sneakerapp.data

import android.util.Log
import com.example.sneakerapp.view.model.ShoeDetails

object ShoppingCart {
    private val shoppingCartList: MutableList<ShoeDetails> = mutableListOf()

    fun addToCart(shoeDetails: ShoeDetails) {
        shoppingCartList.add(shoeDetails)
    }

    fun getCartItems(): List<ShoeDetails> {
        return shoppingCartList.toList()
    }

    fun removeFromCart(id: String) {
        for (shoe in shoppingCartList) {
            if (id == shoe.id) {
                shoppingCartList.remove(shoe)
                break
            }
        }
        println(shoppingCartList.size)
    }
}