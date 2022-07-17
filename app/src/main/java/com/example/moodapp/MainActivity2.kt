package com.example.moodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlin.random.Random
class MainActivity2 : AppCompatActivity() {
    lateinit var img: ImageView
    private var random:java.util.Random =java.util.Random()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        img=findViewById(R.id.image2)
       img.setOnClickListener {
           ClickEmotion()
       }
    }
    private fun ClickEmotion(){
        val rnd = random.nextInt(3)
        var Array = arrayOf(R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_4,R.drawable.img_5,R.drawable.img_6)
        img.setImageResource(Array[rnd])
    }
}
