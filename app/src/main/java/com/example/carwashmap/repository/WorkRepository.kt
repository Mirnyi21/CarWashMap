package com.example.carwashmap.repository

import androidx.lifecycle.LiveData
import com.example.carwashmap.domain.ServicesDao
import com.example.carwashmap.models.ServiceWorkModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WorkRepository(private val servicesDao: ServicesDao) {
    fun insertWork(work : ServiceWorkModel) {
        CoroutineScope(Dispatchers.IO).launch {
            servicesDao.insertWork(work)
        }
    }

    fun update(work: ServiceWorkModel) {
        CoroutineScope(Dispatchers.IO).launch {
            servicesDao.update(work)
        }
    }

    fun deleteByIdWork(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            servicesDao.deleteByIdEntry(id)
        }
    }

    fun deleteWork(work: ServiceWorkModel) {
        CoroutineScope(Dispatchers.IO).launch {
            servicesDao.deleteWork(work)
        }
    }

    fun getAllWork(): LiveData<List<ServiceWorkModel>> {
        return servicesDao.getAllWork()
    }

}