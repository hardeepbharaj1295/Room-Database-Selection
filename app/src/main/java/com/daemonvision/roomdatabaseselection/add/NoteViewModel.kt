package com.daemonvision.roomdatabaseselection.add

import android.content.Context
import androidx.lifecycle.ViewModel
import com.daemonvision.roomdatabaseselection.database.Note
import com.daemonvision.roomdatabaseselection.database.NoteDao
import com.daemonvision.roomdatabaseselection.database.NoteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class NoteViewModel(private val context: Context): ViewModel() {

    private var repository: NoteRepository

    private val viewModel = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModel)

    init {
        val db = NoteDatabase.getInstance(context).noteDao()
        repository = NoteRepository(db)
    }

    fun insert(note: Note)
    {
        uiScope.launch {
            repository.insert(note)
        }
    }

}