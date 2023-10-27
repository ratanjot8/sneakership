package com.example.sneakerapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
import com.example.sneakerapp.R
import com.example.sneakerapp.databinding.ItemProductCardBinding
import com.example.sneakerapp.data.ShoppingCart
import com.example.sneakerapp.view.model.ShoeDetails

class ProductItemsAdapter(
    private val products: List<ShoeDetails>,
    private val detailsListener: (ShoeDetails) -> Unit,
    ) :
    RecyclerView.Adapter<ProductItemsAdapter.ProductAdapterViewHolder>() {

    class ProductAdapterViewHolder(val binding: ItemProductCardBinding) :
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product_card, parent, false)
        val binding =
            ItemProductCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ProductAdapterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductAdapterViewHolder, position: Int) {
        holder.bind(products[position])
        holder.itemView.setOnClickListener { detailsListener(products[position]) }
        holder.binding.addToCartImageview.setOnClickListener { ShoppingCart.addToCart(products[position]) }
    }
}
