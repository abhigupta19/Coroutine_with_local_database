package com.example.assesstmvvm.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface ModelDao {

    @Query("Select * from quote")
    fun getData():LiveData<List<Model>>

    @Insert
    suspend fun insertData( model: Model)
}