package com.herokuapp.oyetekofficial.maintenancelog

import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private val timeout = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            startActivity(Intent(this, LogInActivity::class.java))
            finish()
        }, timeout.toLong())

        // Setting Notification
        val form = SimpleDateFormat("dd-MM-yyyy")
        val today = form.format(Date())
        val dbHelper = DatabaseHelper(this)
        val data = dbHelper.fetchData()
        val stringBuffer = StringBuffer()

        if (data != null && data.count > 0) {
            stringBuffer.append(data.getString(4))
            val date = stringBuffer.toString()

            if (today in date) {
                val notifyBuilder = NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.maintenance_personnel)
                    .setContentTitle("Maintenance Schedule")
                    .setContentText("1 or more job(s) available")
                val notifyManager =
                    getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notifyManager.notify(0, notifyBuilder.build())
            }
        else {
                val notifyBuilder = NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.maintenance_personnel)
                    .setContentTitle("Maintenance Schedule")
                    .setContentText("No job today")
                val notifyManager =
                    getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notifyManager.notify(0, notifyBuilder.build())
            }
    }
}}
