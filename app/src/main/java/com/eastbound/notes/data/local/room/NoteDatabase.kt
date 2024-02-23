package com.eastbound.notes.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.eastbound.notes.data.local.entity.Note

@Database(entities = [Note::class], version = 2)
abstract class NoteDatabase: RoomDatabase() {

    abstract fun dao(): NoteDao

    companion object {
        @Volatile
        private var INSTANCE: NoteDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): NoteDatabase {
            if (INSTANCE == null) {
                synchronized(NoteDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, NoteDatabase::class.java, "note_database").build()
                }
            }
            return INSTANCE as NoteDatabase
        }
    }

}