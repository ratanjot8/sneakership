package com.example.sneakerapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sneakerapp.R
import com.example.sneakerapp.databinding.ActivityMainBinding
import com.example.sneakerapp.view.fragments.CartFragment
import com.example.sneakerapp.view.fragments.PopularItemsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        addPopularFragment()
        setBottomNavigationListener()
    }

    private fun addPopularFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragment_container, PopularItemsFragment(), "")
        fragmentTransaction.commit()
        true
    }

    private fun setBottomNavigationListener() {
        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                com.example.sneakerapp.R.id.home -> {
                    //actionBar!!.title = "Home"
                    val fragment = PopularItemsFragment()
                    val fragmentTransaction = supportFragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.fragment_container, fragment, "")
                    fragmentTransaction.commit()
                    true
                }
                com.example.sneakerapp.R.id.cart -> {
                    //actionBar!!.title = "Cart"
                    val fragment = CartFragment()
                    val fragmentTransaction = supportFragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.fragment_container, fragment, "")
                    fragmentTransaction.commit()
                    true
                }
                else -> false
            }
        }
    }
}