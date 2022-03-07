package com.example.kotlinandroid.project13_xmlparsing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.kotlinandroid.R
import kotlinx.android.synthetic.main.activity_p13_xmlpullpraser.*
import java.io.IOException

class P13XMLPullpraserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_p13_xmlpullpraser)

        var employees: List<Employee>? = null
        try {
            val parser = XmlPullParserHandler()
            val istream = assets.open("employees.xml")
            employees = parser.parse(istream)

            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, employees)
            listView.adapter = adapter

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}