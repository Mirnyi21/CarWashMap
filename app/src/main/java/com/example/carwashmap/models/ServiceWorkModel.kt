package com.example.carwashmap.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "work_list")
data class ServiceWorkModel(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "work") val workName: String,
    @ColumnInfo(name = "price") val workPrice: String
)
