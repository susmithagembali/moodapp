package com.example.moodapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class HistoryActivity : AppCompatActivity() {
    lateinit var hiss: historyadapter
    lateinit var historylist: ArrayList<emotion>
    lateinit var manager: RecyclerView.LayoutManager
    lateinit var recycle: RecyclerView
    lateinit var databasestrg:DatabaseReference
    lateinit var info:emotion
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

//        val current = LocalDateTime.now()
//        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
//        val formatted = current.format(formatter)

        historylist = ArrayList()
        hiss =historyadapter(this,historylist)

        recycle = findViewById(R.id.history)
        recycle.layoutManager= LinearLayoutManager(this)
        recycle.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        recycle.adapter=hiss

        databasestrg=FirebaseDatabase.getInstance().reference

        databasestrg.child("History").addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
               historylist.clear()
               for (postSnapShot in snapshot.children) {
//                   info = snapshot.getValue(emotion::class.java)!!
                   val hmodel =postSnapShot.getValue(emotion::class.java)

                   historylist.add(hmodel!!)
//                   val history = snapshot.getValue(emotion::class.java)
//                historylist.add(snapshot.getValue().toString() as emotion)
               }
                hiss.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@HistoryActivity,"Data Not fetched",Toast.LENGTH_SHORT).show()
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