package com.labs.task4_navigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "First Activity"

        findViewById<Button>(R.id.second_act_main).setOnClickListener {
            startActivity(Intent(applicationContext, SecondActivity::class.java))
        }

        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnItemSelectedListener { item ->
            if (item.itemId == R.id.about) {
                startActivity(Intent(applicationContext, AboutActivity::class.java))
            }
            true
        }

    }
}