package com.daemonvision.roomdatabaseselection.show

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.daemonvision.roomdatabaseselection.add.NoteViewModel
import java.lang.IllegalArgumentException

class ShowViewModelFactory(private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteShowViewModel::class.java))
        {
            return NoteShowViewModel(context) as T
        }
        throw IllegalArgumentException("Invalid Model Class")
    }
}