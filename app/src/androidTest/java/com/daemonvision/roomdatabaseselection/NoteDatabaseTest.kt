package com.daemonvision.roomdatabaseselection

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import com.daemonvision.roomdatabaseselection.database.Note
import com.daemonvision.roomdatabaseselection.database.NoteDao
import com.daemonvision.roomdatabaseselection.database.NoteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class NoteDatabaseTest {

    private lateinit var noteDao: NoteDao
    private lateinit var db: NoteDatabase

    private var viewModel = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModel)

    @Before
    fun createDb()
    {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, NoteDatabase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()

        noteDao = db.noteDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb()
    {
        db.close()
    }

    @Test
    @Throws(IOException::class)
    fun insertAndGetNote(){
        val note = Note(1,"Title","Description")
        uiScope.launch {
            noteDao.insert(note)
        }
        val getNote = noteDao.getRecentNote()
        Assert.assertEquals(getNote?.title, "Title")
    }
}