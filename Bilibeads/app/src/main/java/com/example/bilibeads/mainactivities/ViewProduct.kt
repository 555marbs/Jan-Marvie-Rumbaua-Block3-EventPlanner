package com.example.bilibeads.mainactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.bilibeads.R
import com.example.bilibeads.dataclasses.Products

class ViewProduct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_product)

        val product = intent.getParcelableExtra<Products>("product")
        if (product !=null) {
            val textView: TextView = findViewById(R.id.tv_viewtitle)
            val textView2: TextView = findViewById(R.id.tv_viewprice)
            val imageView: ImageView = findViewById(R.id.iv_viewproduct)

            textView.text = product.title
            imageView.setImageResource(product.image)
            textView2.text = product.price
        }
    }
}