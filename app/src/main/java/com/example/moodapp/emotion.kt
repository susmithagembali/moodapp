package com.example.moodapp

import kotlin.concurrent.timer

class emotion {
    private var emotion: String = ""
    private var comment: String = ""
    private var time: String = ""

    constructor()
    constructor(emotion: String, comment: String ,time: String) {
        this.emotion = emotion
        this.comment = comment
        this.time = time
    }
    fun getEmotion():String?{
        return emotion
    }
    fun setEmotion(emotion: String) {
        this.emotion = emotion
    }
    fun getComment():String?{
        return comment

    }
    fun setComment(comment: String){
        this.comment = comment
    }
    fun getTime():String?{
        return time
    }
    fun setTime(time:String){
        this.time = time
    }
}