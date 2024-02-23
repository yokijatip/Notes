package com.eastbound.notes.ui.main

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eastbound.notes.adapter.NotesAdapter
import com.eastbound.notes.data.local.entity.Note
import com.eastbound.notes.databinding.ActivityMainBinding
import com.eastbound.notes.ui.add.AddNoteActivity
import com.eastbound.notes.ui.ViewModelFactory
import com.eastbound.notes.utils.Helper

class MainActivity : AppCompatActivity(), NotesAdapter.RecyclerViewEvent {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = obtainViewModel(this)
        val adapter = NotesAdapter(emptyList(), this)
        recyclerView = binding.rvNotes
        recyclerView.layoutManager = GridLayoutManager(this,2)
        recyclerView.adapter = adapter


        mainViewModel.getAllNotes().observe(this) {
            adapter.notes = it
            adapter.notifyDataSetChanged()
        }

        binding.apply {
            fabAdd.setOnClickListener {
                addNote()
                onPause()
            }
        }

    }


    private fun addNote() {
        startActivity(Intent(this, AddNoteActivity::class.java))
    }

    private fun obtainViewModel(activity: AppCompatActivity): MainViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory)[MainViewModel::class.java]
    }

    override fun onItemClick(position: Int) {
        TODO("Not yet implemented")
    }

    override fun onItemLongClick(position: Int) {
        mainViewModel.getAllNotes().observe(this) {
            val notes = it[position].id
            Helper.showMessage(this, "$notes : Long Item Clicked ")
        }


    }

}