package com.example.kotlinandroid.project4_intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinandroid.R
import kotlinx.android.synthetic.main.activity_first_implicit.*
import android.content.Intent
import android.net.Uri

class FirstActivityImplicit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_implicit)

        button.setOnClickListener(){
            intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://www.javatpoint.com/"))
            startActivity(intent)
            /*  intent= Intent(Intent.ACTION_VIEW, Uri.parse("https://www.javatpoint.com/"))
            startActivity(intent)*/
        }
    }
}