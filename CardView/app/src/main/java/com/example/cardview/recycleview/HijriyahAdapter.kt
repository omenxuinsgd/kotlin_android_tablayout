package com.example.cardview.recycleview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cardview.R

class HijriyahAdapter (val items: ArrayList<String>, val context: Context) :
    RecyclerView.Adapter<HijriyahAdapter.ViewHolder>() {

//    class CustomAdapter(private val dataSet: Array<String>) :
//        RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

        /**
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder).
         */
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val namaHijriyah: TextView

            init {
                // Define click listener for the ViewHolder's View.
                namaHijriyah = view.findViewById(R.id.namaHijriyah)
            }
        }

        // Create new views (invoked by the layout manager)
        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            // Create a new view, which defines the UI of the list item
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.hijriyah_listitem, viewGroup, false)

            return ViewHolder(view)
        }

        // Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

            // Get element from your dataset at this position and replace the
            // contents of the view with that element
            viewHolder.namaHijriyah.text = items[position]
        }

        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = items.size
    }