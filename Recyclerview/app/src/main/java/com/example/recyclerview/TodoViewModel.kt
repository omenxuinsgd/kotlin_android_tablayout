package com.example.recyclerview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.recyclerview.database.Todo

//class TodoViewModel: ViewModel() {
class TodoViewModel(application: Application): AndroidViewModel(application) {

    private val _todos = MutableLiveData<ArrayList<Todo>>()
//    private var _todos : LiveData<List<Todo>>

    val todos: MutableLiveData<ArrayList<Todo>>
            get()= _todos

    init{
        _todos.value = arrayListOf(
            Todo(1, "mandi"),
            Todo(2, "mencuci")
        )
    }

    fun addTodo (text: String){
        val newId = _todos.value!!.size + 1
        _todos.value!!.add(Todo(newId, text))
        _todos.setValue(_todos.value)
    }

    fun removeTodo (pas: Int){
        _todos.value!!.removeAt(pas)
        _todos.setValue(_todos.value)
    }

    fun updateTodo (pos: Int, text: String){
        _todos.value!![pos].task = text
        _todos.setValue(_todos.value)
    }
}