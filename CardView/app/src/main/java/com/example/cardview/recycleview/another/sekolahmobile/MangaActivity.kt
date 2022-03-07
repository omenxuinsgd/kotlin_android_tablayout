package com.example.cardview.recycleview.another.sekolahmobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cardview.R
import kotlinx.android.synthetic.main.activity_manga.*

class MangaActivity : AppCompatActivity() {
    private var list: ArrayList<Manga> = arrayListOf()
    private lateinit var mangaAdapter: MangaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manga)
        showRecyclerView()
    }

    private fun showRecyclerView() {
        list.addAll(MangaData.listData)
        mangaAdapter = MangaAdapter(list)
        recyclerview_manga.apply{
            layoutManager = LinearLayoutManager(this@MangaActivity)
            adapter = mangaAdapter
            setHasFixedSize(true)
        }
    }
}