package com.example.assesstmvvm.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [Model::class],version=2)
abstract class DatabaseBulider: RoomDatabase() {
     abstract  fun getDao():ModelDao
     companion object{
         var instance:DatabaseBulider?=null
         fun getDatabase(context:Context):DatabaseBulider{
             if(instance==null){

                     instance= Room.databaseBuilder(context,DatabaseBulider::class.java,"model_table").createFromAsset("quotes.db").build()

                 return instance as DatabaseBulider;
                 
             }
             else{
                 return instance as DatabaseBulider
             }
         }
     }
}