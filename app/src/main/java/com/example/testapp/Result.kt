package com.example.testapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class Result : AppCompatActivity() {

    lateinit var correctAns: TextView
    lateinit var totalAns: TextView

    lateinit var output: LinearLayout
    lateinit var home: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_avtivity)
        supportActionBar?.hide()

        correctAns = findViewById(R.id.correctAns)
        totalAns = findViewById(R.id.totalAns)
        home = findViewById(R.id.imageView)

        output = findViewById(R.id.output)

        val intent = intent
        val correctAnsNo = intent.getStringExtra("correct")
        val totalAnsNo = intent.getStringExtra("total")
        correctAns.text = correctAnsNo
        totalAns.text = totalAnsNo

        home.setOnClickListener {
            val intent = Intent(this, MainActivity ::class.java)
            startActivity(intent)
        }


    }
}