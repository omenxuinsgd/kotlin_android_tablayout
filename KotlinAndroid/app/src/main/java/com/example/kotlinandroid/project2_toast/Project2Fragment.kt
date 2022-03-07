package com.example.kotlinandroid.project2_toast

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.kotlinandroid.R
import kotlinx.android.synthetic.main.fragment_project2.view.*

class Project2Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inf = inflater.inflate(R.layout.fragment_project2, container, false)
        val button = inf.button

        button.setOnClickListener(){
            Toast.makeText(requireActivity(),"this is toast message",Toast.LENGTH_SHORT).show()

            val toast = Toast.makeText(requireActivity(), "Hello Javatpoint", Toast.LENGTH_SHORT)
            toast.show()

            val myToast = Toast.makeText(requireActivity(),"toast message with gravity",Toast.LENGTH_SHORT)
            myToast.setGravity(Gravity.LEFT,200,200)
            myToast.show()
        }
        return inf
    }
}