package com.example.moodapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class historyadapter( val his: com.example.moodapp.history,val historylist: ArrayList<emotion>) :RecyclerView.Adapter<historyadapter.history>() {
    class history(view: View):RecyclerView.ViewHolder(view){
        val emotion: TextView = view.findViewById(R.id.emotion1)
        val comment: TextView = view.findViewById(R.id.comment1)
        val timestamp: TextView = view.findViewById(R.id.timestamp)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): history {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.history_recycle,parent,false)
        return history(view)
    }

    override fun onBindViewHolder(holder: history, position: Int) {
        var hmodel: emotion = historylist[position]
        holder.emotion.text = hmodel.getEmotion()
        holder.comment.text = hmodel.getComment()
        holder.timestamp.text = hmodel.getTime()
    }

    override fun getItemCount(): Int {
        return historylist.size
    }

}