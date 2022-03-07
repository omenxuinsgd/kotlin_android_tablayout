package com.example.kotlinandroid.project12_tablayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinandroid.R
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_first_framelayout.view.*
import kotlinx.android.synthetic.main.fragment_second_framelayout.*

class SecondFragmentFramelayout : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second_framelayout, container, false)

        view.androidButton!!.setOnClickListener(View.OnClickListener {
            Toast.makeText(context,"android fragment",Toast.LENGTH_SHORT).show()
        })
        return view
    }
}