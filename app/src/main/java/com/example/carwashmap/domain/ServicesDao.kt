package com.example.carwashmap.domain

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.carwashmap.models.EntryModel
import com.example.carwashmap.models.ServiceWorkModel

@Dao
interface ServicesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWork(work : ServiceWorkModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEntry(entry : EntryModel)

    @Update
    fun update(work: ServiceWorkModel)

    @Query("delete from work_list where id = :id")
    suspend fun deleteByIdWork(id: Int)

    @Query("delete from user_entry where id = :id")
    suspend fun deleteByIdEntry(id: Int)

    // Method #4
    @Delete
    suspend fun deleteWork(work: ServiceWorkModel)

    @Delete
    suspend fun deleteEntry(entry: EntryModel)

    // Method #5
    @Query("select * from work_list")
    fun getAllWork(): LiveData<List<ServiceWorkModel>>

    @Query("select * from user_entry")
    fun getAllEntry(): LiveData<List<EntryModel>>
}