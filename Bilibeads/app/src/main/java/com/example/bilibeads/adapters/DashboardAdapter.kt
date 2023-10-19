package com.example.bilibeads.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bilibeads.dataclasses.Products
import com.example.bilibeads.mainactivities.Dashboard
import com.example.bilibeads.R

class DashboardAdapter(private val getActivity: Dashboard, private val productList: List<Products>) : RecyclerView.Adapter<DashboardAdapter.ViewHolder>(){

    var onItemClick : ((Products) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_cardsview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productList[position]
        holder.productTitle.text = productList[position].title
        holder.productPrice.text = productList[position].price
        holder.productImage.setImageResource(productList[position].image)

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(product)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productTitle : TextView = itemView.findViewById(R.id.cardview_title)
        val productImage : ImageView = itemView.findViewById(R.id.cardview_id)
        val productPrice: TextView = itemView.findViewById(R.id.cardview_price)
    }

}