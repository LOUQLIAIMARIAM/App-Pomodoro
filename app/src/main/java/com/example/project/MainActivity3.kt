package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        supportActionBar?.hide()

        val butto =findViewById<Button>(R.id.button5)
        butto.setOnClickListener {
            val naviger = Intent(this,MainActivity4::class.java)
            startActivity(naviger)
        }

        val butt =findViewById<Button>(R.id.button6)
        butt.setOnClickListener {
            val naviger = Intent(this,MainActivity5::class.java)
            startActivity(naviger)

        }

        val but =findViewById<Button>(R.id.button7)
        but.setOnClickListener {
            val naviger = Intent(this,MainActivity6::class.java)
            startActivity(naviger)
        }
    }
}