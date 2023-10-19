package com.example.bilibeadsdesigns.Dashboard

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.example.bilibeadsdesigns.R

class ViewProduct : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_product)




        val product = intent.getParcelableExtra<Products>("product")
        if (product !=null){
            val textView : TextView = findViewById(R.id.tv_viewtitle)
            val textView2 : TextView = findViewById(R.id.tv_viewprice)
            val imageView : ImageView = findViewById(R.id.iv_viewproduct)

            textView.text = product.title
            imageView.setImageResource(product.image)
            textView2.text = product.price
        }else{
            Log.e("ViewProduct", "Product object is null")
        }

    }
}