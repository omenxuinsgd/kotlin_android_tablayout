package com.example.kotlinandroid.project1_textviewedittext

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.kotlinandroid.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_project1.view.*


class Project1Fragment : Fragment() {
  override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      val inf = inflater.inflate(R.layout.fragment_project1, container, false)
      val button = inf.button
      val editText = inf.editText
      val textView4 =  inf.textView4
      val textView5 =  inf.textView5

      button.setOnClickListener(){
          val inputValue: String = editText.text.toString()
          if (inputValue == null || inputValue.trim()==""){
              Toast.makeText(requireActivity(),"please input data, edit text cannot be blank",Toast.LENGTH_LONG).show()
          }else{
              textView4.setText(inputValue).toString()
          }
      }
      textView5.setOnClickListener {
          if (textView4.text.toString() == null || textView4.text.toString().trim()==""){
              Toast.makeText(requireActivity(),"Tombol telah berhasil diklik",Toast.LENGTH_SHORT).show()
          }else{
              textView4.setText("").toString()
          }
      }
      editText.addTextChangedListener(object: TextWatcher {
          override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
              //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
              Toast.makeText(requireActivity(),"executed before making any change over EditText",Toast.LENGTH_SHORT).show()
          }

          override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
              //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
              Toast.makeText(requireActivity(),"executed while making any change over EditText",Toast.LENGTH_SHORT).show()
          }
          override fun afterTextChanged(p0: Editable?) {
              //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
              Toast.makeText(requireActivity(),"executed after change made over EditText",Toast.LENGTH_SHORT).show()
          }
      })
      return inf
  }
}