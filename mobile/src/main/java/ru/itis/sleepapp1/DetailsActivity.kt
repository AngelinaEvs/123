package ru.itis.sleepapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val unicode1 = 0x1F616
        val unicode2 = 0x1F610
        val unicode3 = 0x1F642
        val unicode4 = 0x1F60A
        val unicode5 = 0x1F970

        findViewById<TextView>(R.id.zero).text =
            intent.getStringExtra("counth") + " часов " + intent.getStringExtra("countm") + " минут " + String(
                Character.toChars(unicode5)
            )
        findViewById<TextView>(R.id.zero).isVisible =
            intent.getStringExtra("counth")?.isNotEmpty() ?: false
        findViewById<TextView>(R.id.one).text =
            "7 часов 3 минуты " + String(Character.toChars(unicode1))
        findViewById<TextView>(R.id.two).text =
            "6 часов 27 минут " + String(Character.toChars(unicode5))
        findViewById<TextView>(R.id.three).text =
            "10 часов 14 минут " + String(Character.toChars(unicode3))
        findViewById<TextView>(R.id.four).text =
            "7 часов 18 минут " + String(Character.toChars(unicode4))

        findViewById<Button>(R.id.button).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        Thread.sleep()
    }
}