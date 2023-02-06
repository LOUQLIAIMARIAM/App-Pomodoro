package com.example.project

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast

class MainActivity4 : AppCompatActivity() {
    val start_time_In_millieseconde : Long = 25 *60 * 1000
    var remainingTime : Long= start_time_In_millieseconde
    var timer:CountDownTimer?=null
    var itsraining= false


    lateinit var titre : TextView
    lateinit var time: TextView
    lateinit var button : Button
    lateinit var rest :TextView
    lateinit var pb:ProgressBar



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        supportActionBar?.hide()


        titre = findViewById(R.id.title)
        time = findViewById(R.id.timer)
        button = findViewById(R.id.botn)
        rest = findViewById(R.id.reseT)
        pb = findViewById(R.id.progressBar)

        button.setOnClickListener {
            if (!itsraining){
             startTimer()
             titre.text= resources.getText(R.string.keep)
        }}

        rest.setOnClickListener {
           restTimer()
            titre.text= resources.getText(R.string.pot)
        }


    }
    private  fun startTimer(){
         timer = object :CountDownTimer(start_time_In_millieseconde,1*1000){
            override fun onTick(timeLeft: Long) {
                remainingTime = timeLeft
                updateTimerText()
                pb.progress = remainingTime.toDouble().div(start_time_In_millieseconde.toDouble()).times(100).toInt()
            }

            override fun onFinish() {
                Toast.makeText(this@MainActivity4,"finich",Toast.LENGTH_SHORT).show()
                itsraining = false
            }

        }.start()
        itsraining = true
    }


    private fun updateTimerText(){
        val minute = remainingTime.div(1000).div(60)
        val second = remainingTime.div(1000)%60
        val formaterTimer = String.format("%02d:%02d",minute,second)
        time.setText(formaterTimer)
    }

    private fun restTimer(){
        timer?.cancel()
        remainingTime = start_time_In_millieseconde
        updateTimerText()
        itsraining = false
        pb.progress = 100
    }
}


