package com.example.carwashmap

import android.app.Application
import com.example.carwashmap.domain.ServiceDatabase
import com.example.carwashmap.repository.EntryRepository
import com.example.carwashmap.repository.WorkRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class BaseApplication : Application() {

    private val applicationScope = CoroutineScope(SupervisorJob())

    private val database by lazy { ServiceDatabase.getDatabase(this, applicationScope) }
    val workRepository by lazy { WorkRepository(database.servicesDao()) }
    val entryRepository by lazy { EntryRepository(database.servicesDao()) }
}