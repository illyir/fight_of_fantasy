package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).setOnClickListener {
            var intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.button2).setOnClickListener {
            var intent2 = Intent(this, MainActivity3::class.java)
            startActivity(intent2)
        }
        findViewById<Button>(R.id.button3).setOnClickListener {
            var intent3 = Intent(this, MainActivity4::class.java)
            startActivity(intent3)
        }
    }
    var a = 0
}