package com.example.bilibeadsdesigns.Dashboard

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.bilibeadsdesigns.R

class ProfilePage : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val getIntent = intent.getStringExtra("profiles")

        val dashboard = findViewById<ImageView>(R.id.iv_logo)
        dashboard.setOnClickListener {
            val intent = Intent(this, Dashboards::class.java)
            startActivity(intent)
        }

        val cart = findViewById<ImageView>(R.id.iv_cart)
        cart.setOnClickListener {
            val intent = Intent(this,ShoppingCart::class.java)
            startActivity(intent)
        }
        
    }
}