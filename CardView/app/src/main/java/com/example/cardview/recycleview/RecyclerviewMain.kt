package com.example.cardview.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cardview.R

class RecyclerviewMain : AppCompatActivity() {
    val bulanHijriyah: ArrayList<String> = ArrayList()

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview_main)

        listBulanHijriyah()
        viewManager = LinearLayoutManager(this)
        viewAdapter = HijriyahAdapter(bulanHijriyah, this)

        recyclerView = findViewById(R.id.hijriyah)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = viewManager
        recyclerView.adapter = viewAdapter
    }

    fun listBulanHijriyah(){
        bulanHijriyah.add("Muharram")
        bulanHijriyah.add("Safar")
        bulanHijriyah.add("Rabiul Awal")
        bulanHijriyah.add("Rabiul Akhir")
        bulanHijriyah.add("Jumadil Awal")
        bulanHijriyah.add("Jumadil Akhir")
        bulanHijriyah.add("Rajab")
        bulanHijriyah.add("Sya'ban")
        bulanHijriyah.add("Syawal")
        bulanHijriyah.add("Dzulkaidah")
        bulanHijriyah.add("Dzulhijjah")
    }
}