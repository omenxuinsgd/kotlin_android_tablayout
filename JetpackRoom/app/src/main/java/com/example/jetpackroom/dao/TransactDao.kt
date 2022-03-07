package com.example.jetpackroom.dao

import androidx.room.*
import com.example.jetpackroom.entity.Transact

@Dao
interface TransactDao {
    @get:Query("SELECT * FROM transact")
    val all: List<Transact>

    @Query("SELECT * FROM transact WHERE uid = :transactId")
    fun detail(transactId: Int): Transact?

    @Insert
    fun insert(transact: Transact)

    @Update
    fun update(transact: Transact)

    @Delete
    fun delete(transact: Transact)
}