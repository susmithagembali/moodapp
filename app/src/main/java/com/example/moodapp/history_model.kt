package com.example.moodapp

class history_model {
    private var emotion = ""
    private var comment = ""
    private var formatted = ""

    constructor()
    constructor(emotion: String, comment: String, formatted: String) {
        this.emotion = emotion
        this.comment = comment
        this.formatted= formatted
    }
    fun getEmotion(): String{
        return this.emotion
    }
    fun setEmotion(comment: String){
        this.emotion = emotion
    }
    fun getComment(): String{
        return this.comment
    }
    fun setComment(comment: String){
        this.comment = comment
    }
    fun getFormatted(): String{
        return this.formatted
    }
    fun setFormatted(formatted: String){
        this.formatted = formatted
    }



}