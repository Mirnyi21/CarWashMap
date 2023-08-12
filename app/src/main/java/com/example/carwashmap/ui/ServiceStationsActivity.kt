package com.example.carwashmap.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carwashmap.R
import com.example.carwashmap.ui.adapters.ServicesAdapter

class ServiceStationsActivity : AppCompatActivity() {

    private val serviceRecyclerView = findViewById<RecyclerView>(R.id.services_rv)
    private val serviceAdapter = ServicesAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_station)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        serviceRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@ServiceStationsActivity)
            serviceRecyclerView.adapter = serviceAdapter
        }
    }

}