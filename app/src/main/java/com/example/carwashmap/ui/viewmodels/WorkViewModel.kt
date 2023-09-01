package com.example.carwashmap.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.carwashmap.models.ServiceWorkModel
import com.example.carwashmap.repository.WorkRepository

class WorkViewModel(workRepository: WorkRepository) : ViewModel() {

    val allServiceWorkLiveData : LiveData<List<ServiceWorkModel>> = workRepository.getAllWork()

}