package com.example.carwashmap.repository

import androidx.lifecycle.LiveData
import com.example.carwashmap.domain.ServicesDao
import com.example.carwashmap.models.EntryModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EntryRepository(private val servicesDao: ServicesDao) {

    fun insertEntry(entry : EntryModel) {
        CoroutineScope(Dispatchers.IO).launch {
            servicesDao.insertEntry(entry)
        }
    }

    fun deleteByIdEntry(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            servicesDao.deleteByIdEntry(id)
        }
    }

    fun deleteEntry(entry: EntryModel) {
        CoroutineScope(Dispatchers.IO).launch {
            servicesDao.deleteEntry(entry)
        }
    }

    fun getAllEntry(): LiveData<List<EntryModel>> {
        return servicesDao.getAllEntry()
    }
}