package com.eastbound.notes.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.eastbound.notes.data.local.entity.Note
import com.eastbound.notes.repository.Repository

class MainViewModel(application: Application) : ViewModel(){

    private val mNoteRepository: Repository = Repository(application)

    fun getAllNotes(): LiveData<List<Note>> = mNoteRepository.getAllNotes()

    fun update(note: Note) {
        mNoteRepository.update(note)
    }

    fun delete(note: Note) {
        mNoteRepository.delete(note)
    }

}