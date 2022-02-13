package com.example.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.assesstmvvm.Database.DatabaseBulider
import com.example.assesstmvvm.Database.Model
import com.example.assesstmvvm.Database.ModelDao
import com.example.assesstmvvm.Repo.MainActRepo
import com.example.assesstmvvm.viewmodel.MainViewModel
import com.example.assesstmvvm.viewmodel.MainViewModelFactory
import com.example.coroutine.R

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModelFactory: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_main)
        val modelDao=DatabaseBulider.getDatabase(applicationContext).getDao()
        val mainViewRepo=MainActRepo(modelDao)
        mainViewModelFactory=ViewModelProvider(this,MainViewModelFactory(mainViewRepo)).get(MainViewModel::class.java)

        mainViewModelFactory.getData().observe(this,{
            findViewById<TextView>(R.id.text).text=it.toString();
        }
        )
        findViewById<TextView>(R.id.insert).setOnClickListener {
            val model=Model(0,"test","abhinav");
            mainViewModelFactory.insertData(model);
        }

    }
}