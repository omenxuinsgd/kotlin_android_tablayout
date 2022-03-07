package com.example.kotlinandroid.project5_listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_project5_listview.*
import com.example.kotlinandroid.R

class Project5ListviewActivity : AppCompatActivity() {
    //val language = arrayOf<String>("C","C++","Java",".Net","Kotlin","Ruby","Rails","Python","Java Script","Php","Ajax","Perl","Hadoop")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project5_listview)

        val language: Array<String> = resources.getStringArray(R.array.technology_list)
        val arrayAdapter = ArrayAdapter<String>(this@Project5ListviewActivity, android.R.layout.simple_list_item_1, language)

        listView.adapter = arrayAdapter
        listView.onItemClickListener =
            AdapterView.OnItemClickListener { adapterView, view, position, id ->
                val selectedItem = adapterView.getItemAtPosition(position) as String
                val itemIdAtPos = adapterView.getItemIdAtPosition(position)

                Toast.makeText(
                    applicationContext,
                    "click item $selectedItem its position $itemIdAtPos",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }
}