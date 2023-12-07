package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val list:Array<Notice>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate((R.layout.activity_product_detail),
            parent,false)
        return MyViewHolder(itemView)

    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=list[position]
        holder.title.text=currentItem.title
        holder.text.text=currentItem.text
        holder.date.text=currentItem.date
    }

    override fun getItemCount(): Int {

        return list.size
    }


    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val title:TextView=itemView.findViewById(R.id.title)
        val text:TextView=itemView.findViewById(R.id.text)
        val date:TextView=itemView.findViewById(R.id.date)

    }

}