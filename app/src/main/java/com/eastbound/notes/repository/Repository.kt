package com.eastbound.notes.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.eastbound.notes.data.local.entity.Note
import com.eastbound.notes.data.local.room.NoteDao
import com.eastbound.notes.data.local.room.NoteDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class Repository(application: Application) {

    private val mNotesDao: NoteDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = NoteDatabase.getDatabase(application)
        mNotesDao = db.dao()
    }

    fun getAllNotes(): LiveData<List<Note>> = mNotesDao.getAllNotes()

    fun insert(note: Note) {
        executorService.execute {
            mNotesDao.insert(note)
        }
    }

    fun delete(note: Note) {
        executorService.execute {
            mNotesDao.delete(note)
        }
    }

    fun update(note: Note) {
        executorService.execute {
            mNotesDao.update(note)
        }
    }

}