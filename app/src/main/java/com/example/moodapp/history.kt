package com.example.moodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class history : AppCompatActivity() {
    lateinit var hiss: historyadapter
    lateinit var historylist: ArrayList<emotion>
    lateinit var manager: RecyclerView.LayoutManager
    lateinit var recycle: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        recycle = findViewById(R.id.history)
        val ob1 = emotion("happy","i am happy","7:00")
        val ob2 = emotion("sad","i am sad","7:00")
        val ob3 = emotion("angry","i am angry","7:00")
        historylist.add(ob1)
        historylist.add(ob2)
        historylist.add(ob3)
       manager =  LinearLayoutManager(this)
        hiss = historyadapter(this,historylist)
        recycle.adapter = hiss
        recycle.layoutManager = manager
    }
}