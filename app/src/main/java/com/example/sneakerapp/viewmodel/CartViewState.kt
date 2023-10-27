package com.example.sneakerapp.viewmodel

import com.example.sneakerapp.view.model.ProductItems
import com.example.sneakerapp.view.model.ShoeDetails

data class CartViewState(
    val total: Int,
    val isLoading: Boolean,
    val items: List<ShoeDetails>? = null
)