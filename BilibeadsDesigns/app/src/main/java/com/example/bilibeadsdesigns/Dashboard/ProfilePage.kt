package com.example.bilibeadsdesigns.Dashboard

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.bilibeadsdesigns.R

class ProfilePage : AppCompatActivity() {
    private lateinit var cart: TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        cart = findViewById(R.id.tv_profile_page)

        val getIntent = intent.getStringExtra("profiles")
    }
}