package com.example.sneakerapp.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.sneakerapp.databinding.FragmentPopularItemsBinding
import com.example.sneakerapp.view.adapter.ProductItemsAdapter
import com.example.sneakerapp.viewmodel.PopularViewModel


class PopularItemsFragment : Fragment() {
    private lateinit var popularViewModel: PopularViewModel
    private lateinit var binding: FragmentPopularItemsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPopularItemsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        popularViewModel = ViewModelProvider(this).get(PopularViewModel::class.java)
        context?.let { popularViewModel.getPopularItemsData(it) }

        initialiseLiveDataObservers()

    }

    private fun initialiseLiveDataObservers() {
        popularViewModel.viewState.observe(viewLifecycleOwner, Observer { value->
            if (!value.isLoading) {
                binding.itemsRecyclerview.apply {
                    layoutManager = GridLayoutManager(activity, 2)
                    adapter = value.items?.let { ProductItemsAdapter(it.shoeDetailsList) { shoe->
                        Log.d("hello", shoe.name.toString())
                    } }

                }
            }

        })
    }
}