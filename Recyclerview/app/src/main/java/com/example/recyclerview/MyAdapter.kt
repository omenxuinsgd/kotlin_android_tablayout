package com.example.recyclerview

import android.app.AlertDialog
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.database.Todo
import com.example.recyclerview.databinding.ItemListBinding

class MyAdapter(private val viewModel: TodoViewModel) :
//    RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    ListAdapter<Todo, MyAdapter.ViewHolder>(TodoDiffCallback()) {

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val inflater = LayoutInflater.from(viewGroup.context)
        val binding = ItemListBinding.inflate(inflater)

        return ViewHolder(binding)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your viewModel.todos.value!! at this position and replace the
        // contents of the view with that element
//        viewHolder.textView.text = viewModel.todos.value!![position].task
        viewHolder.textView.text = getItem(viewHolder.adapterPosition).task
        
        // menghapus
        viewHolder.delete.setOnClickListener{
//            viewModel.todos.value!!.removeAt(position)
            viewModel.removeTodo(viewHolder.adapterPosition)
        }

        // mengupdate
        viewHolder.edit.setOnClickListener {
            val context = viewHolder.itemView.context

            val inflater = LayoutInflater.from(context)
            val view = inflater.inflate(R.layout.item_edit, null)

            // mengambil data sebelumnya
//            val prevText = viewModel.todos.value!![position].task
            val prevText = getItem(viewHolder.adapterPosition).task
            val editTexts = view.findViewById<TextView>(R.id.editText)
            editTexts.text = prevText

            // dilaog
            val alertDialog = AlertDialog.Builder(context)
            alertDialog.setTitle("Edit Item")
                .setView(view)
                .setPositiveButton("Update", DialogInterface.OnClickListener{
                    dialog, id ->

                    //edit
//                    viewModel.todos.value!![position].task = editTexts.text.toString()
                    val editedText = editTexts.text.toString()
                    viewModel.updateTodo(viewHolder.adapterPosition, editedText)
                    viewHolder.textView.text = editedText
                })
                .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                        dialog, id ->

                })
            alertDialog.create().show()

        }
    }

    // Return the size of your viewModel.todos.value!! (invoked by the layout manager)
//    override fun getItemCount(): Int {
//        return viewModel.todos.value!!.size
//    }

    class ViewHolder(binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        val textView: TextView
        val delete: Button
        val edit: Button

        init {
            // Define click listener for the ViewHolder's View.
            textView = binding.todoItem
            delete = binding.deleteBtn
            edit = binding.editBtn
        }
    }
    }

class TodoDiffCallback: DiffUtil.ItemCallback<Todo>() {
    override fun areItemsTheSame(p0: Todo, p1: Todo): Boolean {
        return p0.id == p1.id
    }

    override fun areContentsTheSame(p0: Todo, p1: Todo): Boolean {
        return p0 == p1
    }
}
