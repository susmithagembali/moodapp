package com.example.moodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var but:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        but=findViewById(R.id.button2)
        but.setOnClickListener {
            val i=Intent(this,MainActivity2::class.java)
            startActivity(i)
        }
    }
}