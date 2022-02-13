package com.example.assesstmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assesstmvvm.Database.Model
import com.example.assesstmvvm.Repo.MainActRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(val mainActRepo: MainActRepo) : ViewModel() {

    fun getData():LiveData<List<Model>> {
        return mainActRepo.getData();
    }

    fun insertData(model: Model){

        viewModelScope.launch { Dispatchers.IO
            mainActRepo.insertData(model);
        }

    }

}