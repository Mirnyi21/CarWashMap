package com.example.carwashmap.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.carwashmap.R
import com.example.carwashmap.ui.viewmodels.EntryViewModel

class EntryActivity : AppCompatActivity() {

    private lateinit var entryViewModel: EntryViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry)

        setupViewModel()

    }

    private fun setupViewModel() {
        entryViewModel =
            ViewModelProvider(this)[EntryViewModel::class.java]
    }
}