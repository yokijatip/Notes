package com.eastbound.notes.ui.add

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.eastbound.notes.data.local.entity.Note
import com.eastbound.notes.databinding.ActivityDetailBinding
import com.eastbound.notes.ui.ViewModelFactory
import com.eastbound.notes.utils.Helper

class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var addNoteViewModel: AddNoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addNoteViewModel = obtainViewModel(this)


        binding.apply {
            fabSave.setOnClickListener {
                saveNote()
            }
        }


    }

    private fun saveNote() {
        binding.apply {
            val title = edtTitleInput.text.toString()
            val content = edtContentInput.text.toString()
            val backgroundColor = Helper.randomColor()

            when {
                title.isEmpty() -> {
                    edtContentInput.error = "Field can not be blank"
                }

                content.isEmpty() -> {
                    edtContentInput.error = "Field can not be blank"
                }

//                    Proses Add Note
                else -> {
                    val note = Note(
                        id = 0,
                        title = title,
                        content = content,
                        date = Helper.getCurrentDate(),
                        color = backgroundColor
                    )
                    addNoteViewModel.insert(note)
                    finish()
                }
            }
        }
    }


    private fun obtainViewModel(activity: AppCompatActivity): AddNoteViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory)[AddNoteViewModel::class.java]
    }
}