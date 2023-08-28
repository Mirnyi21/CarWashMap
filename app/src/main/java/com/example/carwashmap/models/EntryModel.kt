package com.example.carwashmap.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "user_entry")
data class EntryModel(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "service_name") val serviceName: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "time") val time: String,
    @ColumnInfo(name = "car") val car: String,
    @ColumnInfo(name = "service_work") val serviceWork: String
)
