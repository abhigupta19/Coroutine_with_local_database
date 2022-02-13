package com.example.assesstmvvm.Database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote")
data class Model(
    @PrimaryKey(autoGenerate = true)
    val id:Int ,
    val text:String,
    val author:String

)