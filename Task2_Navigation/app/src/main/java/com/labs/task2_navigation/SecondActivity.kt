package com.labs.task2_navigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        title = "Activity2"

        findViewById<Button>(R.id.bnToFirst).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.bnToThird).setOnClickListener {
            startActivityForResult(
                Intent(applicationContext, ThirdActivity::class.java),
                Nav.TO_SECOND)
        }

        findViewById<BottomNavigationView>(R.id.nav_view).setOnItemSelectedListener { item ->
            if (item.itemId == R.id.about) {
                startActivity(Intent(applicationContext, AboutActivity::class.java))
            }
            true
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Nav.TO_FIRST) finish()
    }
}