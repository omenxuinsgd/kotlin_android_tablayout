package com.example.notivication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

//        3 detik splash
        val intent = Intent(this@SplashActivity, MainActivity::class.java)
        Handler().postDelayed({
            startActivity(intent)
            finish()
        }, 3000)
    }
}