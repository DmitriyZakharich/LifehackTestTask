package com.example.lifehacktesttask.screens.list_screen.domain

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.lifehacktesttask.R
import com.example.lifehacktesttask.screens.list_screen.domain.models.CompanyDomain
import com.squareup.picasso.Picasso

class CustomRecyclerAdapter(
        private val data: List<CompanyDomain>,
) : RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>() {

    private val picasso = Picasso.get()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.companyId.text = data[position].id
        holder.companyName.text = data[position].name

        picasso.load("https://lifehack.studio/test_task/${data[position].img}").into(holder.imageView)

        val bundle = Bundle().apply {
            putString("id", data[position].id)
        }
        holder.itemView.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_listFragment_to_detailsFragment,
                bundle))
    }

    override fun getItemCount() = data.size

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val companyId: TextView = itemView.findViewById(R.id.company_id)
        val companyName: TextView = itemView.findViewById(R.id.company_name)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }
}