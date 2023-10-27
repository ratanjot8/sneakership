package com.example.sneakerapp.viewmodel

import com.example.sneakerapp.view.model.ProductItems

data class PopularViewState(
    val isLoading: Boolean,
    val items: ProductItems? = null
)
