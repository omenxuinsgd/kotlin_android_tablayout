package com.example.jetpackroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackroom.entity.Transact

class TransactAdapter(
    private val items: List<Transact>,
    private val event: (Transact) -> Unit
) : RecyclerView.Adapter<TransactAdapter.ViewHolder>() {

    inner class ViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        var tvName: TextView? = null
        var tvDate: TextView? = null

        init {
            tvName = row.findViewById(R.id.name)
            tvDate = row.findViewById(R.id.date)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_transact_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.tvName?.text = item.nameTransact
        holder.tvDate?.text = item.createdDate
        holder.itemView.setOnClickListener {
            event.invoke(item)
        }
    }
}