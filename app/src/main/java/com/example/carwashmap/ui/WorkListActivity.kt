package com.example.carwashmap.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carwashmap.R
import com.example.carwashmap.ui.adapters.WorkAdapter

class WorkListActivity : AppCompatActivity() {

    private val workAdapter = WorkAdapter()
    private val workListRecyclerView = findViewById<RecyclerView>(R.id.work_list_rv)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_list)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        workListRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@WorkListActivity)
            workListRecyclerView.adapter = workAdapter
        }
    }
}

