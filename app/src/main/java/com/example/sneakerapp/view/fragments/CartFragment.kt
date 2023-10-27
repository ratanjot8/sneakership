package com.example.sneakerapp.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sneakerapp.R
import com.example.sneakerapp.data.ShoppingCart
import com.example.sneakerapp.databinding.FragmentCartBinding
import com.example.sneakerapp.databinding.FragmentPopularItemsBinding
import com.example.sneakerapp.view.adapter.CartItemAdapter
import com.example.sneakerapp.view.adapter.ProductItemsAdapter
import com.example.sneakerapp.viewmodel.CartViewModel
import com.example.sneakerapp.viewmodel.PopularViewModel

class CartFragment : Fragment() {
    private lateinit var cartViewModel: CartViewModel
    private lateinit var binding: FragmentCartBinding
    private lateinit var cartAdapter: CartItemAdapter
    var removalPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cartViewModel = ViewModelProvider(this).get(CartViewModel::class.java)
        cartViewModel.getCartItems()
        initialiseLiveDataObservers()

    }

    private fun initialiseLiveDataObservers() {
        cartViewModel.viewState.observe(viewLifecycleOwner, Observer { value->
            if (!value.isLoading) {
                if (value.items?.isEmpty() == true) {
                    binding.cartLayout.visibility = View.GONE
                    binding.emptyTextview.visibility = View.VISIBLE
                }
                else {
                    binding.cartLayout.visibility = View.VISIBLE
                    binding.emptyTextview.visibility = View.GONE

                    binding.itemsRecyclerview.apply {
                        layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
                        adapter = value.items?.let { CartItemAdapter(it) { shoe, position ->
                            cartViewModel.removeFromCart(shoe.id)
                            removalPosition = position
                        } }?.apply {
                            notifyItemRemoved(removalPosition)
                            notifyItemRangeChanged(removalPosition, ShoppingCart.getCartItems().size)
                        }
                    }
                }

            }

        })
    }

}