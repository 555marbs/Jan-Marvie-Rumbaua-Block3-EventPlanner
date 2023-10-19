package com.example.bilibeadsdesigns.Product


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.ViewFlipper
import androidx.recyclerview.widget.RecyclerView
import com.example.bilibeadsdesigns.Dashboard.Dashboards
import com.example.bilibeadsdesigns.Dashboard.Products
import com.example.bilibeadsdesigns.R

class Product_RecyclerView_Adapter (private val getActivity: Dashboards, private val productList: List<Products>):
    RecyclerView.Adapter<Product_RecyclerView_Adapter.MyViewHolder>() {


    var onItemClick : ((Products) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_cardsview, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val product = productList[position]
        holder.productTitle.text = productList[position].title
        holder.productPrice.text = productList[position].price
        //holder.productImage.setImageResource(productList[position].image)
        holder.productImage.setImageResource(product.image)
        holder.itemView.setOnClickListener{
            onItemClick?.invoke(product)
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productTitle : TextView = itemView.findViewById(R.id.tv_title)
        val productImage : ImageView = itemView.findViewById(R.id.iv_beads)
        val productPrice: TextView = itemView.findViewById(R.id.tv_price)


    }

}