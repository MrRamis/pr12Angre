package com.example.pr217.model.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrder(ordersEntity : OrdersEntity)
    @Delete
    suspend fun deleteOrder(ordersEntity : OrdersEntity)
    @Query("SELECT * FROM OrdersEntity")
    suspend fun getAllOrders():List<OrdersEntity>
}