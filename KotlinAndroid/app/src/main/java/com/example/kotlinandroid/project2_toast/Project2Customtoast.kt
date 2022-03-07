package com.example.kotlinandroid.project2_toast

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.kotlinandroid.R
import kotlinx.android.synthetic.main.custom_toast.*
import kotlinx.android.synthetic.main.fragment_project2_customtoast.view.*

class Project2Customtoast : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val lyt = inflater.inflate(R.layout.fragment_project2_customtoast, container, false)
        val layout = layoutInflater.inflate(R.layout.custom_toast,linearLayout)
        val button = lyt.button
        //getting the View object as defined in the custom_toast.xml file
//        val layout = layoutInflater.inflate(R.layout.custom_toast,linearLayout)
        button.setOnClickListener(){
            val myToast = Toast(requireActivity())
            myToast.duration = Toast.LENGTH_LONG
            myToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
            myToast.view = layout//setting the view of custom toast layout
            myToast.show()
        }
        return lyt
    }

}