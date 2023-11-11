package com.example.pr217.model.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(
    entities = [OrdersEntity::class],
    version = 5
)
abstract class MainDb:RoomDatabase() {
    companion object{
        fun  createDataBase(context: Context): MainDb
        {
            return Room.databaseBuilder(
                context,
                MainDb::class.java,
                "test1.db"
            ).build()
        }
    }
    abstract fun dao(): Dao
}