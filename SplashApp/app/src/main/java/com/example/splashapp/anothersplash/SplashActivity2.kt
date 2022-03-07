package com.example.splashapp.anothersplash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.splashapp.R

class SplashActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash2)

        val splashTime: Long = 3000 // lama splashscreen berjalan

        Handler().postDelayed({
            val intent = Intent(this, SplashActivity::class.java)
            startActivity(intent) // Pindah ke Home Activity setelah 3 detik
            finish()
        }, splashTime)
    }
}