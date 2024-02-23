package com.eastbound.notes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.eastbound.notes.R
import com.eastbound.notes.data.local.entity.Note

@Suppress("DEPRECATION")
class NotesAdapter(var notes: List<Note>, private val listener: RecyclerViewEvent): RecyclerView.Adapter<ViewHolder>() {

    interface RecyclerViewEvent {
        fun onItemClick(position: Int)
        fun onItemLongClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_note, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val note = notes[position]
        val viewHolder = holder as ViewHolder

        viewHolder.tvTitle.text = note.title
        viewHolder.tvContent.text = note.content
        viewHolder.tvDate.text = note.date
        viewHolder.itemView.findViewById<ConstraintLayout>(R.id.base_card).setBackgroundResource(note.color)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnLongClickListener {
        val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        val tvContent: TextView = itemView.findViewById(R.id.tv_content)
        val tvDate: TextView = itemView.findViewById(R.id.tv_date)

        init {
            itemView.setOnLongClickListener(this)
        }

        override fun onLongClick(v: View?): Boolean {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION){
                listener.onItemLongClick(position)
                return true
            }
            return false
        }

    }

}