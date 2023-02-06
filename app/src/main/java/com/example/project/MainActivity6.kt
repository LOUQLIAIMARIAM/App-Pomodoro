package com.example.project

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast

class MainActivity6 : AppCompatActivity() {

    val start_temps : Long = 15 *60 * 1000
    var remningTime : Long= start_temps
    var temps: CountDownTimer?=null
    var israning= false

    lateinit var le_titre : TextView
    lateinit var timing: TextView
    lateinit var botonn : Button
    lateinit var resti : TextView
    lateinit var pba: ProgressBar


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)
        supportActionBar?.hide()

        le_titre = findViewById(R.id.tito)
        timing = findViewById(R.id.temps)
        botonn = findViewById(R.id.bot)
        resti  = findViewById(R.id.rese)
        pba = findViewById(R.id.progres)


        botonn.setOnClickListener {
            if (! israning){
                startTimer()
                le_titre.text= resources.getText(R.string.keep)
            }}

        resti.setOnClickListener {
            restTimer()
            le_titre.text= resources.getText(R.string.pot)
        }

    }

    private  fun startTimer(){
        temps = object :CountDownTimer(start_temps,1*1000){
            override fun onTick(timeLeft: Long) {
                remningTime = timeLeft
                updateTimerText()
                pba.progress = remningTime.toDouble().div(start_temps.toDouble()).times(100).toInt()
            }

            override fun onFinish() {
                Toast.makeText(this@MainActivity6,"finich", Toast.LENGTH_SHORT).show()
                israning = false
            }

        }.start()
        israning = true
    }


    private fun updateTimerText(){
        val minute = remningTime.div(1000).div(60)
        val second = remningTime.div(1000)%60
        val formaterTimer = String.format("%02d:%02d",minute,second)
        timing.setText(formaterTimer)
    }

    private fun restTimer(){
        temps?.cancel()
        remningTime = start_temps
        updateTimerText()
        israning = false
        pba.progress = 100
    }
}