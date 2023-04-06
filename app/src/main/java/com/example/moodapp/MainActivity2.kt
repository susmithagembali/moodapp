package com.example.moodapp

import android.app.Dialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
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
    lateinit var storage:DatabaseReference
    private var firebaseUserId:String = ""
    lateinit var auth: FirebaseAuth
    private var random:java.util.Random =java.util.Random()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        img=findViewById(R.id.image2)
       img.setOnClickListener {
           ClickEmotion()
       }
        but4=findViewById(R.id.button4)
        but4.setOnClickListener {
           showcommentdailogue()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun showcommentdailogue() {
        val showcomment = Dialog(this)
        showcomment.setContentView(R.layout.comment_dailogue)
        showcomment.setCancelable(false)
        showcomment.setCanceledOnTouchOutside(false)
        showcomment.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        val emmotion = showcomment.findViewById<EditText>(R.id.emotion)
        val comment= showcomment.findViewById<EditText>(R.id.comment)
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val formatted = current.format(formatter)
        showcomment.findViewById<Button>(R.id.showbutton).setOnClickListener {
          scomment=comment.text.toString().trim { it <= ' ' }
            sEmotion=emmotion.text.toString().trim { it <= ' '}
            if (sEmotion.isEmpty()){
                Toast.makeText(this,"enter your emotion",Toast.LENGTH_SHORT).show()
            }
            else if (scomment.isEmpty()){
                Toast.makeText(this,"enter your comment",Toast.LENGTH_SHORT).show()
            }
            else{
                sendData(sEmotion,scomment,formatted)
            }
        }


        showcomment.show()
    }

    private fun sendData(sEmotion: String, scomment: String, formatted: String) {
           firebaseUserId=auth.currentUser!!.uid
           storage= FirebaseDatabase.getInstance().reference.child("History").child(formatted)
        val userHashMap=HashMap<String,Any>()
        userHashMap["date"]=formatted
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
