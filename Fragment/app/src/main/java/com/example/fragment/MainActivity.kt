package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.OneShotPreDrawListener.add

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager!!.
        beginTransaction().
        add(R.id.fragmentContainer,FragmentOne(),"FragmentOne").commit()
    }
}