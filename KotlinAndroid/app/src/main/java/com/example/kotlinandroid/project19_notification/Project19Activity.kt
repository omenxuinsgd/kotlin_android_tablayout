package com.example.kotlinandroid.project19_notification

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.example.kotlinandroid.R
import kotlinx.android.synthetic.main.activity_project19.*


class Project19Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project19)

        button.setOnClickListener { addNotification() }
    }

    fun addNotification()
    {
        val builder: Notification.Builder? = Notification.Builder(this)
            .setSmallIcon(R.drawable.swift) //set icon for notification
            .setContentTitle("Notifications Example") //set title of notification
            .setContentText("This is a notification message") //this is notification message
            .setAutoCancel(true)//set priority of notification


        val notificationIntent = Intent(this, NotificationViewActivity::class.java)
        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        //notification message will get at NotificationView
        //notification message will get at NotificationView
        notificationIntent.putExtra("message", "This is a notification message")

        val pendingIntent = PendingIntent.getActivity(
            this, 0, notificationIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        builder!!.setContentIntent(pendingIntent)

        // Add as notification

        // Add as notification
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(0, builder!!.build())
    }
}