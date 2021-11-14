package com.labs.task3_navigation

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        title = "Third Activity"

        findViewById<Button>(R.id.bnToFirst).setOnClickListener {
            val i = Intent(applicationContext, MainActivity::class.java)
            i.flags = FLAG_ACTIVITY_CLEAR_TOP
            startActivity(i)
        }

        findViewById<Button>(R.id.bnToSecond).setOnClickListener {
            val i = Intent(applicationContext, SecondActivity::class.java)
            i.flags = FLAG_ACTIVITY_CLEAR_TOP
            startActivity(i)
        }

        findViewById<BottomNavigationView>(R.id.nav_view).setOnItemSelectedListener { item ->
            if (item.itemId == R.id.about) {
                startActivity(Intent(applicationContext, AboutActivity::class.java))
            }
            true
        }

    }

}