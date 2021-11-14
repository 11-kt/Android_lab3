package com.labs.task3_navigation

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
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        findViewById<Button>(R.id.bnToSecond).setOnClickListener {
            startActivity(Intent(applicationContext, SecondActivity::class.java))
        }

        findViewById<BottomNavigationView>(R.id.nav_view).setOnItemSelectedListener { item ->
            if (item.itemId == R.id.about) {
                startActivity(Intent(applicationContext, AboutActivity::class.java))
            }
            true
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}