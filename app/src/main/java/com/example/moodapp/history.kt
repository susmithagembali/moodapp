package com.example.moodapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class history : AppCompatActivity() {
    lateinit var hiss: historyadapter
    lateinit var historylist: ArrayList<emotion>
    lateinit var manager: RecyclerView.LayoutManager
    lateinit var recycle: RecyclerView
    lateinit var databasestrg:DatabaseReference
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        recycle = findViewById(R.id.history)
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val formatted = current.format(formatter)
        databasestrg=FirebaseDatabase.getInstance().reference
        recycle.layoutManager=LinearLayoutManager(this)
        recycle.adapter=hiss
        databasestrg.child("History").child(formatted.substring(0,2)).addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
              // historylist.clear()
               for (postSnapShot in snapshot.children) {
                   val currentUser=postSnapShot.getValue(emotion::class.java)
               }
                hiss.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
//        val ob1 = emotion("happy","i am happy","7:00")
//        val ob2 = emotion("sad","i am sad","7:00")
//        val ob3 = emotion("angry","i am angry","7:00")
//        historylist.add(ob1)
//        historylist.add(ob2)
//        historylist.add(ob3)
//       manager =  LinearLayoutManager(this)
//        hiss = historyadapter(this,historylist)
//        recycle.adapter = hiss
//        recycle.layoutManager = manager

    }
}