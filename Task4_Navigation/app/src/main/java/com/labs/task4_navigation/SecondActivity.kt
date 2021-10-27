package com.labs.task4_navigation

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NO_HISTORY
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        title = "Second Activity"

        findViewById<Button>(R.id.first_act_second).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.third_act_second).setOnClickListener {
            startActivity(Intent(
                applicationContext,
                ThirdActivity::class.java).addFlags(FLAG_ACTIVITY_NO_HISTORY))
        }

        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnItemSelectedListener { item ->
            if (item.itemId == R.id.about) {
                startActivity(Intent(applicationContext, AboutActivity::class.java))
            }
            true
        }
    }
}