package com.example.cardview.recycleview.recyclercard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cardview.R
import kotlinx.android.synthetic.main.list_erthu.view.*

class Adapter(private val list:ArrayList<Users>) : RecyclerView.Adapter<Adapter.Holder>(){
    class Holder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_erthu,parent,false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.view.lbList.text = list?.get(position)?.name
    }

    override fun getItemCount(): Int = list?.size
}