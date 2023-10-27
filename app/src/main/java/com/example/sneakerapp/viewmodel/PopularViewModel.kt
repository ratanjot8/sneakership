package com.example.sneakerapp.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sneakerapp.data.repository.PopularItemsRepository
import com.example.sneakerapp.view.model.ProductItems
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PopularViewModel: ViewModel() {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    private val mutableviewState: MutableLiveData<PopularViewState> = MutableLiveData()
    val viewState: LiveData<PopularViewState> = mutableviewState

    init {
        mutableviewState.value = PopularViewState(isLoading = false)
    }

    fun getPopularItemsData(context: Context) {
        mutableviewState.value = mutableviewState.value?.copy(isLoading = true)
        coroutineScope.launch {
            val response = PopularItemsRepository().getPopularItemsData(context)
            withContext(Dispatchers.Main) {
                mutableviewState.value = mutableviewState.value?.copy(
                    items = response,
                    isLoading = false
                )
            }
        }
    }
}