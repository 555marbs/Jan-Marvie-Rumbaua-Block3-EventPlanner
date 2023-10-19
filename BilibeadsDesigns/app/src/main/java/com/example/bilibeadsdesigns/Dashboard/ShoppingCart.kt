package com.example.bilibeadsdesigns.Dashboard

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.bilibeadsdesigns.R

class ShoppingCart : AppCompatActivity() {
    private lateinit var cart: TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_cart)

        cart = findViewById(R.id.tv_shopping)


        val getIntent = intent.getStringExtra("cart")
    }
}