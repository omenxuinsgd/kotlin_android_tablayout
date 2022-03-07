package com.example.sqlite.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.sqlite.data.User
import com.example.sqlite.data.UserDatabase
import com.example.sqlite.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<User>>
        get() {
            TODO()
        }
    private val repository: UserRepository

    init{
        val userDao = UserDatabase.getDatabase(
            application
        ).userDao()
        repository = UserRepository(userDao)
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            repository.addUser(user)
        }
    }
    fun updateUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateUser(user)
        }
    }
}