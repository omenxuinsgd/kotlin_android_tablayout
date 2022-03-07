package com.example.kotlinandroid.project4_intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinandroid.R
import kotlinx.android.synthetic.main.activity_second_explicit.*
import android.content.Intent
import android.widget.Toast
import com.example.kotlinandroid.project4_intent.FirstActivityExplicit

class SecondActivityExplicit : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_explicit)

        val bundle: Bundle? = intent.extras
        val id = bundle?.get("id_value")
        val language = bundle?.get("language_value")
        Toast.makeText(applicationContext,id.toString()+" "+language,Toast.LENGTH_LONG).show()
        button2.setOnClickListener(){
            intent = Intent(this,FirstActivityExplicit::class.java)
            startActivity(intent)
        }
    }
}