package com.example.moodapp

class history_model {
    private var emotion = ""
    private var comment = ""
    private var timestamp = ""

    constructor()
    constructor(emotion: String, comment: String, timestamp: String) {
        this.emotion = emotion
        this.comment = comment
        this.timestamp = timestamp
    }
    fun getEmotion(): String{
        return this.emotion
    }
    fun setEmotion(emotion: String){
        this.emotion = emotion
    }



}