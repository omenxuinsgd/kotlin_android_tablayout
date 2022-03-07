package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FragmentOne : Fragment() {
    private lateinit var goToButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_one, container, false)
        goToButton = rootView.findViewById(R.id.gotoButton)

        goToButton.setOnClickListener{
            val fm = fragmentManager

            fm!!.beginTransaction()
                .replace(R.id.fragmentContainer,FragmentTwo(),"FragmentTwo")
                .addToBackStack(null).commit()
        }
        return rootView
    }
}