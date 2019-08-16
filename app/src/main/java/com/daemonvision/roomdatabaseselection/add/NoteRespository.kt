package com.daemonvision.roomdatabaseselection.add

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.daemonvision.roomdatabaseselection.database.Note
import com.daemonvision.roomdatabaseselection.database.NoteDao

class NoteRepository(private val noteDao: NoteDao) {

    val allNotes: LiveData<List<Note>> = noteDao.getAllNotes()

    @WorkerThread
    suspend fun insert(note: Note)
    {
        noteDao.insert(note)
    }

}