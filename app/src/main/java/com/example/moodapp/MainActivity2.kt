package com.example.moodapp

import android.app.Dialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity2 : AppCompatActivity() {
    lateinit var img: ImageView
    lateinit var but4:ImageButton
    lateinit var scomment:String
    lateinit var sEmotion:String
    lateinit var sDay:String
    lateinit var storage:DatabaseReference
    lateinit var history:ImageButton
    lateinit var auth: FirebaseAuth
    private var random:java.util.Random =java.util.Random()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        history=findViewById(R.id.button)
        img=findViewById(R.id.image2)
       img.setOnClickListener {
           ClickEmotion()
       }
        but4=findViewById(R.id.button4)
        but4.setOnClickListener {
           showcommentdailogue()

        }

        history.setOnClickListener {
            val i = Intent(this,HistoryActivity::class.java)
            startActivity(i)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun showcommentdailogue() {
        val showcomment = Dialog(this)
        showcomment.setContentView(R.layout.comment_dailogue)
       // showcomment.setCancelable(false)
        showcomment.setCanceledOnTouchOutside(false)
        showcomment.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        val emmotion = showcomment.findViewById<EditText>(R.id.emotion)
        val comment= showcomment.findViewById<EditText>(R.id.comment)
        val day = showcomment.findViewById<EditText>(R.id.etDay)
//        val current = LocalDateTime.now()
//        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
//        val formatted = current.format(formatter)

        showcomment.findViewById<Button>(R.id.showbutton).setOnClickListener {
          scomment=comment.text.toString().trim { it <= ' ' }
            sEmotion=emmotion.text.toString().trim { it <= ' '}
            sDay = day.text.toString().trim { it <= ' ' }
//            format = formatted.toString()
            if (sEmotion.isEmpty()){
                Toast.makeText(this,"enter your emotion",Toast.LENGTH_SHORT).show()
            }
            else if (scomment.isEmpty()){
                Toast.makeText(this,"enter your comment",Toast.LENGTH_SHORT).show()
            } else if (sDay.isEmpty()) {
                Toast.makeText(this, "enter the day", Toast.LENGTH_SHORT).show()
            }
            else{
                sendData(sEmotion,scomment,sDay)
            }
        }


        showcomment.show()
    }

    private fun sendData(sEmotion: String, scomment: String,sDay: String) {
           storage= FirebaseDatabase.getInstance().reference.child("History").child(sDay)
        val userHashMap=HashMap<String,Any>()
        userHashMap["day"] = sDay
//        userHashMap["formatted"]=formatted
        userHashMap["emotion"]=sEmotion
        userHashMap["comment"]=scomment
        storage.updateChildren(userHashMap).addOnCompleteListener {
            if (it.isSuccessful){
                Toast.makeText(this,"comment saved",Toast.LENGTH_SHORT).show()
               // close()

            }
            else{
                Toast.makeText(this,"comment not saved",Toast.LENGTH_SHORT).show()
            }
        }

    }

    /*private fun close() {
        val showcomment = Dialog(this)
        showcomment.dismiss()
    }*/

    private fun ClickEmotion(){
        val rnd = random.nextInt(3)
        var Array = arrayOf(R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_4,R.drawable.img_5,R.drawable.img_6)
        img.setImageResource(Array[rnd])
    }
}
