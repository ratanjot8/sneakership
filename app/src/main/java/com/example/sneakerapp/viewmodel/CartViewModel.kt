package com.example.sneakerapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sneakerapp.data.ShoppingCart

class CartViewModel: ViewModel() {
    private val mutableviewState: MutableLiveData<CartViewState> = MutableLiveData()
    val viewState: LiveData<CartViewState> = mutableviewState

    init {
        mutableviewState.value = CartViewState(isLoading = false, total = 0)
    }

    fun getCartItems() {
        mutableviewState.value = mutableviewState.value?.copy(
            items = ShoppingCart.getCartItems(),
            isLoading = false
        )
    }

    fun removeFromCart(id: String) {
        ShoppingCart.removeFromCart(id)
    }
}