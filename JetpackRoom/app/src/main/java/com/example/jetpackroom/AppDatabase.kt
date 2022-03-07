package com.example.jetpackroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.jetpackroom.dao.ProductDao
import com.example.jetpackroom.dao.TransactDao
import com.example.jetpackroom.entity.Product
import com.example.jetpackroom.entity.Transact

@Database(entities = [(Transact::class), (Product::class)], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun transactDao(): TransactDao
    abstract fun productDao(): ProductDao

    companion object {

        private var sInstance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (sInstance == null) {
                sInstance = Room
                    .databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "shopping"
                    )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return sInstance!!
        }
    }

}