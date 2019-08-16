package com.daemonvision.roomdatabaseselection.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.daemonvision.roomdatabaseselection.R
import com.daemonvision.roomdatabaseselection.database.Note

class AddNoteActivity : AppCompatActivity() {

    private lateinit var viewModel: NoteViewModel
    private lateinit var viewModelFactory: NoteViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        viewModelFactory = NoteViewModelFactory(this)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(NoteViewModel::class.java)

    }

    public fun insertion(view: View)
    {
        val title = findViewById<EditText>(R.id.title)
        val description = findViewById<EditText>(R.id.description)

        val note = Note(null,title.text.toString(),description.text.toString())
        viewModel.insert(note)
        Toast.makeText(this,"Data Inserted",Toast.LENGTH_SHORT).show()
    }
}
