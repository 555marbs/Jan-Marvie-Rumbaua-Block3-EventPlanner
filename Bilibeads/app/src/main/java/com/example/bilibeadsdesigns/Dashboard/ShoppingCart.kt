package com.example.bilibeadsdesigns.Dashboard

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.bilibeadsdesigns.R

class ShoppingCart : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_cart)

        val getIntent = intent.getStringExtra("cart")

        val dashboard = findViewById<ImageView>(R.id.iv_logo)
        dashboard.setOnClickListener {
            val intent = Intent(this,Dashboards::class.java)
            startActivity(intent)
        }

        val profilepage = findViewById<ImageView>(R.id.iv_profile)
        profilepage.setOnClickListener {
            val intent = Intent(this,ProfilePage::class.java)
            startActivity(intent)
        }
    }
}