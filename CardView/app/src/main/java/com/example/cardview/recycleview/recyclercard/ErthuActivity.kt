package com.example.cardview.recycleview.recyclercard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cardview.R
import kotlinx.android.synthetic.main.activity_erthu.*

class ErthuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_erthu)

        val list = ArrayList<Users>()
        val listUsers = arrayOf(
            "Google",
            "Apple",
            "Microsoft",
            "Asus",
            "Zenpone",
            "Acer"
        )

        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)

        for (i in 0 until listUsers.size){

            list.add(Users(listUsers.get(i)))

            if(listUsers.size - 1 == i){
                // init adapter yang telah dibuat tadi
                val adapter = Adapter(list)
                adapter.notifyDataSetChanged()

                //tampilkan data dalam recycler view
                mRecyclerView.adapter = adapter
            }
        }
    }
}