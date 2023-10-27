package com.example.sneakerapp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.sneakerapp.R
import com.example.sneakerapp.databinding.FragmentPopularItemsBinding
import com.example.sneakerapp.databinding.FragmentShoeDetailsBinding
import com.example.sneakerapp.viewmodel.PopularViewModel

class ShoeDetailsFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoeDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        /*binding.sneakership.setOnClickListener {
            val fragmentTransaction = activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.remove(ShoeDetailsFragment())
            fragmentTransaction?.commit()
            true
        }*/

    }

}