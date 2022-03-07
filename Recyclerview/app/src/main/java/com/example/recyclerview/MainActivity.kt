package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.database.Todo
import com.example.recyclerview.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: MyAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    private lateinit var viewModel: TodoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(TodoViewModel::class.java)


//        viewAdapter = MyAdapter(todos)
        viewAdapter = MyAdapter(viewModel)
        viewManager = LinearLayoutManager(this)

        binding.newBtn.setOnClickListener{
//            todos.add(binding.newText.text.toString())
//            viewModel.todos.value!!.add(Todo(3, binding.newText.text.toString()))
            viewModel.addTodo(binding.newText.text.toString())
            binding.newText.setText(null)
        }

        recyclerView = binding.myRecyclview

        recyclerView.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        viewModel.todos.observe(this, Observer { list ->
            viewAdapter.submitList(list.toMutableList())
        })
    }
}