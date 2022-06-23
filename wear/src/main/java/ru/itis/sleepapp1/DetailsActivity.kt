package ru.itis.sleepapp1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import ru.itis.sleepapp1.databinding.ActivityDetailsBinding
import ru.itis.sleepapp1.databinding.ActivityMainBinding

class DetailsActivity : Activity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)


        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val unicode1 = 0x1F616
        val unicode2 = 0x1F610
        val unicode3 = 0x1F642
        val unicode4 = 0x1F60A
        val unicode5 = 0x1F970

        binding.zero.text = intent.getStringExtra("counth") + " часов " + intent.getStringExtra("countm") + " минут " + String(Character.toChars(unicode5))
        binding.zero.isVisible = intent.getStringExtra("counth")?.isNotEmpty() ?: false
        binding.one.text = "7 часов 3 минуты " + String(Character.toChars(unicode1))
        binding.two.text = "6 часов 27 минут " + String(Character.toChars(unicode5))
        binding.three.text = "10 часов 14 минут " + String(Character.toChars(unicode3))
        binding.four.text = "7 часов 18 минут " + String(Character.toChars(unicode4))

        binding.button.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}