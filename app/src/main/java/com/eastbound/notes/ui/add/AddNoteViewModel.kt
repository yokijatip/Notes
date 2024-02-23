package com.eastbound.notes.ui.add

import android.app.Application
import androidx.lifecycle.ViewModel
import com.eastbound.notes.data.local.entity.Note
import com.eastbound.notes.repository.Repository

class AddNoteViewModel(application: Application) : ViewModel() {

    private val mNoteRepository: Repository = Repository(application)

    fun insert(note: Note) {
        mNoteRepository.insert(note)
    }

    fun update(note: Note) {
        mNoteRepository.update(note)
    }

    fun delete(note: Note) {
        mNoteRepository.delete(note)
    }

}