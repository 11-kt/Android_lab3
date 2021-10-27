package com.labs.task2_navigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        title = "Activity3"

        findViewById<Button>(R.id.first_act_third).setOnClickListener {
            setResult(Nav.TO_FIRST)
            finish()
        }

        findViewById<Button>(R.id.second_act_third).setOnClickListener {
            setResult(Nav.TO_SECOND)
            finish()
        }

        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnItemSelectedListener { item ->
            if (item.itemId == R.id.about) {
                startActivity(Intent(applicationContext, AboutActivity::class.java))
            }
            true
        }

    }
}