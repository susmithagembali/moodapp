package com.example.moodapp

import kotlin.concurrent.timer

class emotion {
    private var emotion: String = ""
    private var comment: String = ""
    private var formatted: String = ""
    private var day:String = ""

    constructor()
    constructor(emotion: String, comment: String ,formatted: String,day:String) {
        this.emotion = emotion
        this.comment = comment
        this.formatted = formatted
        this.day = day
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
    fun getFormatted():String?{
        return formatted
    }
    fun setFormatted(formatted:String){
        this.formatted = formatted
    }

    fun getDay():String?{
        return day
    }

    fun setDay(day: String){
        this.day = day
    }
}