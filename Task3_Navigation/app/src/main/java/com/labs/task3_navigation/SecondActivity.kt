package com.labs.task3_navigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        title = "Second Activity"

        findViewById<Button>(R.id.bnToFirst).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.bnToThird).setOnClickListener {
            startActivity(Intent(applicationContext, ThirdActivity::class.java))
        }

        findViewById<BottomNavigationView>(R.id.nav_view).setOnItemSelectedListener { item ->
            if (item.itemId == R.id.about) {
                startActivity(Intent(applicationContext, AboutActivity::class.java))
            }
            true
        }
    }
}