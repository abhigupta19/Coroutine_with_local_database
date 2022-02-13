package com.example.assesstmvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assesstmvvm.Repo.MainActRepo

class MainViewModelFactory(private  val mainActRepo: MainActRepo):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(mainActRepo) as T
    }
}