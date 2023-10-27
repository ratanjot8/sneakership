package com.example.sneakerapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sneakerapp.R
import com.example.sneakerapp.databinding.ItemCartProductCardBinding
import com.example.sneakerapp.view.model.ShoeDetails

class CartItemAdapter(
    private val products: List<ShoeDetails>,
    private val detailsListener: (ShoeDetails, Int) -> Unit,
) :
    RecyclerView.Adapter<CartItemAdapter.CartAdapterViewHolder>() {

    class CartAdapterViewHolder(val binding: ItemCartProductCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ShoeDetails) {
            with(binding) {
                productNameTextview.text = item.name
                productPriceTextview.text = "$${item.retailPrice}"
                /*Glide.with(productImageview.context)
                    .load(item.image)
                    .into(productImageview)*/
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartAdapterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product_card, parent, false)
        val binding =
            ItemCartProductCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CartAdapterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: CartAdapterViewHolder, position: Int) {
        holder.bind(products[position])
        holder.itemView.setOnClickListener { detailsListener(products[position], position) }
    }
}
