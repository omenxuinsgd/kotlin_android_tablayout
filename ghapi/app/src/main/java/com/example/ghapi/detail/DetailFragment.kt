package com.example.ghapi.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.ghapi.R
import com.example.ghapi.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var viewModel: DeatilViewModel
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_detail, container, false)
        binding = FragmentDetailBinding.inflate(inflater)
        binding.setLifecycleOwner(this)

        //accept args
        var argUsername = DetailFragmentArgs.fromBundle(requireArguments()).username
        val vmfactory = DetailViewModelFactory(argUsername)

        binding.viewModel = ViewModelProvider(this, vmfactory)
            .get(DeatilViewModel::class.java)

        return binding.root
    }

}