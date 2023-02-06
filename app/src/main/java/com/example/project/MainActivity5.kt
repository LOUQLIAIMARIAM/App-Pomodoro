package com.example.project

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast

class MainActivity5 : AppCompatActivity() {

    val start_time: Long =5 *60 * 1000
    var romainingTime : Long= start_time
    var time: CountDownTimer?=null
    var israining= false

    lateinit var title : TextView
    lateinit var timee: TextView
    lateinit var boton : Button
    lateinit var rester : TextView
    lateinit var pbs: ProgressBar



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        supportActionBar?.hide()


        title = findViewById(R.id.titro)
        timee = findViewById(R.id.timo)
        boton = findViewById(R.id.botno)
        rester = findViewById(R.id.reseTo)
        pbs = findViewById(R.id.progresBar)




        boton.setOnClickListener {
            if (!israining){
                startTimer()
                title.text= resources.getText(R.string.keep)
            }}

        rester.setOnClickListener {
            restTimer()
            title.text= resources.getText(R.string.pot)
        }



    }
    private  fun startTimer(){
        time = object :CountDownTimer(start_time,1*1000){
            override fun onTick(timeLeft: Long) {
                romainingTime= timeLeft
                updateTimerText()
                pbs.progress = romainingTime.toDouble().div(start_time.toDouble()).times(100).toInt()
            }

            override fun onFinish() {
                Toast.makeText(this@MainActivity5,"finich", Toast.LENGTH_SHORT).show()
                israining = false
            }

        }.start()
        israining = true
    }


    private fun updateTimerText(){
        val minute = romainingTime.div(1000).div(60)
        val second = romainingTime.div(1000)%60
        val formaterTimer = String.format("%02d:%02d",minute,second)
        timee.setText(formaterTimer)
    }

    private fun restTimer(){
        time?.cancel()
        romainingTime = start_time
        updateTimerText()
        israining = false
        pbs.progress = 100
    }
}