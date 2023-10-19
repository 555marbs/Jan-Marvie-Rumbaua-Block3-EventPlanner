package com.example.bilibeads.mainactivities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bilibeads.R
import com.example.bilibeads.adapters.DashboardAdapter
import com.example.bilibeads.dataclasses.Products

class Dashboard : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var productRecyclerviewAdapter: DashboardAdapter? = null
    private var productList = mutableListOf<Products>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        //val shoppingcart = findViewById<ImageView>(R.id.iv_cart)
        //val profile = findViewById<ImageView>(R.id.iv_profile)
        //val customize = findViewById<Button>(R.id.bt_customize)
        productList = ArrayList()

        recyclerView = findViewById<View>(R.id.dashboard_rv) as RecyclerView
        this.productRecyclerviewAdapter = DashboardAdapter(this@Dashboard, productList)
        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(this,2)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = productRecyclerviewAdapter

        productRecyclerviewAdapter!!.onItemClick = {
            val intent = Intent(this,ViewProduct::class.java)
            intent.putExtra("product", it)
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
}