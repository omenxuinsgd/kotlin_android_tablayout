package com.example.cardview.recycleview.another

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cardview.R
import kotlinx.android.synthetic.main.activity_pratamawijaya.*

class PratamawijayaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pratamawijaya)

        val listHeroes = listOf(
            Hero(name = "Spider-Man", image = "https://i.annihil.us/u/prod/marvel/i/mg/9/30/538cd33e15ab7/standard_xlarge.jpg"),
            Hero(name = "Black Panther", image = "https://i.annihil.us/u/prod/marvel/i/mg/1/c0/537ba2bfd6bab/standard_xlarge.jpg"),
            Hero(name = "Iron Man", image = "https://i.annihil.us/u/prod/marvel/i/mg/6/a0/55b6a25e654e6/standard_xlarge.jpg")
        )

        val heroesAdapter = HeroAdapter(listHeroes)

        rvMain.apply {
            layoutManager = LinearLayoutManager(this@PratamawijayaActivity)
            adapter = heroesAdapter
        }
    }
}