package com.example.assesstmvvm.Repo

import androidx.lifecycle.LiveData
import com.example.assesstmvvm.Database.Model
import com.example.assesstmvvm.Database.ModelDao

class MainActRepo(val modelDao: ModelDao) {


    fun getData():LiveData<List<Model>>{
        return modelDao.getData();
    }

    suspend fun insertData( model: Model){
        modelDao.insertData(model)
    }
}