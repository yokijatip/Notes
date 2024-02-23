package com.eastbound.notes.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eastbound.notes.R
import com.eastbound.notes.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}