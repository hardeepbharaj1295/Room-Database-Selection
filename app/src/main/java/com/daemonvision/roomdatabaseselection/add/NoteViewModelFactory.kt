package com.daemonvision.roomdatabaseselection.add

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NoteViewModelFactory(private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewModel::class.java))
        {
            return NoteViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown View Model")
    }
}