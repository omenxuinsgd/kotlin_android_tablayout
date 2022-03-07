package com.example.jetpackroom.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.jetpackroom.entity.Product

@Dao
interface ProductDao {
    @Query("SELECT * FROM product WHERE transact_id = :transactId")
    fun allByTransact(transactId: Int): List<Product>

    @Insert
    fun insert(product: Product)

    @Delete
    fun delete(product: Product)
}