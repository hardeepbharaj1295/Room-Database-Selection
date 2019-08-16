package com.daemonvision.roomdatabaseselection.show

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.daemonvision.roomdatabaseselection.add.NoteRepository
import com.daemonvision.roomdatabaseselection.database.Note
import com.daemonvision.roomdatabaseselection.database.NoteDatabase

class NoteShowViewModel(private val context: Context): ViewModel() {

    private val repository: NoteRepository
    val allNotes: LiveData<List<Note>>

    init {
        val noteDao = NoteDatabase.getInstance(context).noteDao()
        repository = NoteRepository(noteDao)

        allNotes = repository.allNotes
    }
}