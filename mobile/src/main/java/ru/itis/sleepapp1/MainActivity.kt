package ru.itis.sleepapp1

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val unicode1 = 0x1F616
        val unicode2 = 0x1F610
        val unicode3 = 0x1F642
        val unicode4 = 0x1F60A
        val unicode5 = 0x1F970

        findViewById<TextView>(R.id.one).text = String(Character.toChars(unicode1))
        findViewById<TextView>(R.id.two).text = String(Character.toChars(unicode2))
        findViewById<TextView>(R.id.three).text = String(Character.toChars(unicode3))
        findViewById<TextView>(R.id.four).text = String(Character.toChars(unicode4))
        findViewById<TextView>(R.id.five).text = String(Character.toChars(unicode5))

        onClick()

        findViewById<Button>(R.id.button).setOnClickListener {
            startActivity(Intent(this, DetailsActivity::class.java).apply {
                putExtra("counth", findViewById<EditText>(R.id.editText).text.toString())
                putExtra("countm", findViewById<EditText>(R.id.editText1).text.toString())
            })
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun onClick() {
        val intent = Intent(this, MainActivity::class.java)
        intent.apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        var mNotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val id = "my_channel_01"
        val name: CharSequence = "Доброе утро!"
        val description = "Нажмите на +, если хотите добавить данные о сне"
        val importance = NotificationManager.IMPORTANCE_LOW
        val mChannel = NotificationChannel(id, name, importance)
        mChannel.description = description
        mChannel.enableLights(true)
        mChannel.lightColor = Color.RED
        mChannel.enableVibration(true)
        mChannel.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
        mNotificationManager.createNotificationChannel(mChannel)

        mNotificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        val notifyID = 1
        val CHANNEL_ID = "my_channel_01"
        val notification = Notification.Builder(this@MainActivity)
            .setContentTitle("Доброе утро!")
            .setContentText("Нажмите, если хотите добавить данные о сне")
            .setSmallIcon(android.R.drawable.ic_input_add)
            .setChannelId(CHANNEL_ID)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()
        mNotificationManager.notify(notifyID, notification)
    }
}