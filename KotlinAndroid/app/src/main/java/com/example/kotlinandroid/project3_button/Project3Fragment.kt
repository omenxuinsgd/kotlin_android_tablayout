package com.example.kotlinandroid.project3_button

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.kotlinandroid.R
import kotlinx.android.synthetic.main.fragment_project3.*
import kotlinx.android.synthetic.main.fragment_project3.view.*

class Project3Fragment : Fragment() {
    val button4_Id: Int = 1111

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_project3, container, false)

        button1.setOnClickListener(){
            Toast.makeText(requireActivity(),"button 1 clicked", Toast.LENGTH_SHORT).show()
        }
        //button2.setOnClickListener()
        // add button dynamically
        val button4 = Button(requireActivity())
        button4.setText("Button 4 added dynamically")
        button4.setLayoutParams(ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        button4.setId(button4_Id)
        button4.x = 250f
        button4.y = 500f
        //button4.setOnClickListener()
        constraintLayout.addView(button4)
    }
    fun onClick(view: View) {
        //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        when (view.id) {
            R.id.button2 ->
                Toast.makeText(requireActivity(),"button 2 clicked", Toast.LENGTH_SHORT).show()//single line code
            button4_Id->{//multiline code
                val myToast = Toast.makeText(requireActivity(),"button 4 clicked", Toast.LENGTH_SHORT)
                myToast.show()
            }
        }
    }
    fun clickButton(v: View){
        val mToast = Toast.makeText(requireActivity(),"button 3 clicked", Toast.LENGTH_SHORT)
        mToast.show()
    }
}