package com.daemonvision.roomdatabaseselection

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.daemonvision.roomdatabaseselection.add.AddNoteActivity
import com.daemonvision.roomdatabaseselection.show.NoteAdapter
import com.daemonvision.roomdatabaseselection.show.NoteShowViewModel
import com.daemonvision.roomdatabaseselection.show.ShowViewModelFactory

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val viewModelFactory = ShowViewModelFactory(this)
        val noteShowViewModel = ViewModelProviders.of(this,viewModelFactory).get(NoteShowViewModel::class.java)

        val recyclerView = findViewById<RecyclerView>(R.id.list)
        val adapter = NoteAdapter(this)
        recyclerView.adapter = adapter

        noteShowViewModel.allNotes.observe(this, Observer { notes ->
            notes?.let {
                adapter.setNotes(it)
            }
        })

        fab.setOnClickListener { view ->
            val intent = Intent(this,AddNoteActivity::class.java)
            startActivity(intent)
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
