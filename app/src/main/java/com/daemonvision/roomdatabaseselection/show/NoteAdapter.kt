package com.daemonvision.roomdatabaseselection.show

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.daemonvision.roomdatabaseselection.R
import com.daemonvision.roomdatabaseselection.database.Note
import kotlinx.android.synthetic.main.activity_add_note.view.*

class NoteAdapter(val context: Context): RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    var notes = listOf<Note>()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = notes[position]
        holder.title.text = item.title
        holder.description.text = item.description
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = notes.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val title = itemView.findViewById<TextView>(R.id.title)
        val description = itemView.findViewById<TextView>(R.id.description)
    }

    internal fun setNotes(notes: List<Note>) {
        this.notes = notes
        notifyDataSetChanged()
    }

}