package com.example.bilibeadsdesigns.Dashboard

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bilibeadsdesigns.Customize.Customize
import com.example.bilibeadsdesigns.Product.Product_RecyclerView_Adapter
import com.example.bilibeadsdesigns.R

class Dashboards : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var productRecyclerviewAdapter: Product_RecyclerView_Adapter? = null


    private var productList = mutableListOf<Products>()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboards)

        val customizeButton = findViewById<AppCompatButton>(R.id.bt_customize)
        val profileButton = findViewById<ImageView>(R.id.iv_profile)
        val cartButton = findViewById<ImageView>(R.id.iv_cart)

        customizeButton.setOnClickListener {
            val intent = Intent(this, Customize::class.java)
            startActivity(intent)
            Toast.makeText(this, "Customize Room", Toast.LENGTH_SHORT).show()
        }
        profileButton.setOnClickListener {
            val intent = Intent(this, ProfilePage::class.java)
            startActivity(intent)

        }
        cartButton.setOnClickListener {
            val intent = Intent (this, ShoppingCart::class.java)
            startActivity(intent)
        }


        productList = ArrayList()

        recyclerView = findViewById<View>(R.id.rv_dashboard) as RecyclerView
        this.productRecyclerviewAdapter = Product_RecyclerView_Adapter(this@Dashboards, productList)
        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(this,2)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = productRecyclerviewAdapter


        productRecyclerviewAdapter!!.onItemClick = {  item ->
            val intent = Intent(this, ViewProduct::class.java)
            intent.putExtra("product", item)
            startActivity(intent)

        }
        prepareProductListData()


    }


    private fun prepareProductListData() {
        var beads = Products("Stussy Inpired",R.drawable.finalbead1,"40PHP")
        productList.add(beads)
        beads = Products("Renek",R.drawable.finalbead2,"40PHP")
        productList.add(beads)
        beads = Products("Pinkish",R.drawable.finalbead3,"40PHP")
        productList.add(beads)
        beads = Products("Blackwhite",R.drawable.finalbead4,"40PHP")
        productList.add(beads)
        beads = Products("Stussy Inspired Bracelet",R.drawable.finalbead1,"40PHP")
        productList.add(beads)
        beads = Products("Renek",R.drawable.finalbead2,"40PHP")
        productList.add(beads)
        beads = Products("Pinkish",R.drawable.finalbead3,"40PHP")
        productList.add(beads)
        beads = Products("Blackwhite",R.drawable.finalbead4,"40PHP")
        productList.add(beads)

        productRecyclerviewAdapter!!.notifyDataSetChanged()
    }
    private fun yapyapyapyap(){

    }



}