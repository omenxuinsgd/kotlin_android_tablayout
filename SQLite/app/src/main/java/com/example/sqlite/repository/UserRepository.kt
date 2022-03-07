package com.example.sqlite.repository

import androidx.lifecycle.LiveData
import com.example.sqlite.data.User
import com.example.sqlite.data.UserDao

class UserRepository(private val userDao: UserDao) {
    val readAllData: UserDao = userDao

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

    suspend fun updateUser(user: User){
        userDao.updateUser(user)
    }

    suspend fun deleteUser(user: User){
        userDao.deleteUser(user)
    }

    suspend fun deleteAllUser(){
        userDao.deleteAllUser()
    }
}