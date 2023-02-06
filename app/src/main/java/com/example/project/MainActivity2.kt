package com.example.project

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {
    private val caterg ="Work"
    private val personne ="Personel"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar?.hide()
        val but :Button=findViewById(R.id.boton_item)
        val edit : EditText=findViewById(R.id.add_item)
        val text:TextView=findViewById(R.id.text_Name)
        val dropdown :AutoCompleteTextView = findViewById(R.id.cater)
        val list = listOf(caterg ,personne)
        val adapter = ArrayAdapter(this,R.layout.listitem,list)
        dropdown.setAdapter(adapter)

         but.setOnClickListener {
           val name = edit.text.toString()
            text.setText(name.toString())
         }

        val button =findViewById<Button>(R.id.button3)

        button.setOnClickListener {
            val naviger = Intent(this,MainActivity::class.java)
            startActivity(naviger)
        }

        val butto =findViewById<Button>(R.id.button2)
        butto.setOnClickListener {
            val naviger = Intent(this,MainActivity3::class.java)
            startActivity(naviger)
        }
    }



}