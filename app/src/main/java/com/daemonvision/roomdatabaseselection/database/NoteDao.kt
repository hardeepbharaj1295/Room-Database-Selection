package com.daemonvision.roomdatabaseselection.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert
    suspend fun insert(note: Note)

    @Query("SELECT * FROM note_table")
    fun getAllNotes(): LiveData<List<Note>>

    @Query("SELECT * FROM note_table ORDER BY id DESC LIMIT 1")
    fun getRecentNote(): Note?

    @Query("SELECT * FROM note_table WHERE id= :key")
    fun getNote(key: Int): Note

    @Update
    fun noteUpdate(note: Note)

    @Query("DELETE FROM note_table WHERE id = :key")
    fun deleteNote(key: Int)
}