package com.example.carwashmap.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carwashmap.R
import com.example.carwashmap.models.ServiceWorkModel
import com.example.carwashmap.ui.adapters.WorkAdapter
import com.example.carwashmap.ui.viewmodels.WorkViewModel

class WorkListActivity : AppCompatActivity() {


    private lateinit var workViewModel: WorkViewModel
    private lateinit var allWork : List<ServiceWorkModel>
    private val workAdapter = WorkAdapter(allWork)
    private val workListRecyclerView = findViewById<RecyclerView>(R.id.work_list_rv)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_list)

        setupViewModel()
        observerLiveData()
        initRecyclerView()

    }

    private fun setupViewModel() {
        workViewModel =
            ViewModelProvider(this)[WorkViewModel::class.java]
    }

    private fun initRecyclerView() {
        workListRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@WorkListActivity)
            workListRecyclerView.adapter = workAdapter
        }
    }

    private fun observerLiveData() {
        workViewModel.allServiceWorkLiveData.observe(this) { works ->
            works?.let {
                allWork = it
            }
        }
    }
}

