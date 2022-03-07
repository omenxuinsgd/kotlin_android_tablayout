package com.example.kotlinandroid.project4_intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinandroid.R
import kotlinx.android.synthetic.main.activity_first_explicit.*
import android.content.Intent
import com.example.kotlinandroid.project4_intent.SecondActivityExplicit

class FirstActivityExplicit : AppCompatActivity() {
    val id:Int = 10
    val language:String = "kotlin"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_explicit)

        button.setOnClickListener() {
            intent = Intent(this, SecondActivityExplicit::class.java)
            intent.putExtra("id_value", id)
            intent.putExtra("language_value", language)
            startActivity(intent)
        }
    }
}