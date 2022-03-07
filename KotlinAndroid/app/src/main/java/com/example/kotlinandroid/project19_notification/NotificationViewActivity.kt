package com.example.kotlinandroid.project19_notification

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinandroid.R
import kotlinx.android.synthetic.main.activity_notification_view.*

class NotificationViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_view)

        val message = intent.getStringExtra("message")
        textView.setText(message)
    }
}