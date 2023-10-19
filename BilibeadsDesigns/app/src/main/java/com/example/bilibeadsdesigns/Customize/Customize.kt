package com.example.bilibeadsdesigns.Customize

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bilibeadsdesigns.R
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bilibeadsdesigns.Dashboard.Dashboards

class Customize : AppCompatActivity() {
    private var currentImageViewIndex = 0
    private lateinit var imageViewArray: Array<ImageView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customize)

        imageViewArray = Array(15) {
            findViewById(resources.getIdentifier("viewImage${it + 1}", "id", packageName))
        }

        val backButton = findViewById<ImageView>(R.id.back_button)
        backButton.setOnClickListener{
            val intent = Intent (this, Dashboards::class.java)
            startActivity(intent)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.rv_productList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val layoutManager:RecyclerView.LayoutManager = GridLayoutManager(this, 2)
        recyclerView!!.layoutManager = layoutManager

        val itemList = listOf(
            ListItem(R.drawable.beads1),
            ListItem(R.drawable.beads2),
            ListItem(R.drawable.beads3)
        )

        val adapter = MyAdapter(itemList) { position ->
            if (currentImageViewIndex < imageViewArray.size) {
                imageViewArray[currentImageViewIndex].setImageResource(itemList[position].imageResource)
                currentImageViewIndex++
            }
        }

        recyclerView.adapter = adapter

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener {
            resetImageViews()
        }

        val clearButton: Button = findViewById(R.id.clear_button)
        clearButton.setOnClickListener {
            clearImageView()
        }

    }

    fun clearImageView() {
        if (currentImageViewIndex > 0) {
            currentImageViewIndex--
            imageViewArray[currentImageViewIndex].setImageResource(0)
        }

    }

    fun resetImageViews() {
        for (imageView in imageViewArray) {
            imageView.setImageResource(R.drawable.card_view_color)
        }
        currentImageViewIndex = 0
    }

}