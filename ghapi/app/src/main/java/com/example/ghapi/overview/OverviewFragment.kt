package com.example.ghapi.overview

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.ghapi.databinding.FragmentOverviewBinding

class OverviewFragment : Fragment() {
    private lateinit var binding: FragmentOverviewBinding
    private lateinit var viewModel: OverviewViewModel

//    private lateinit var viewModel: OverviewViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_overview, container, false)
        binding = FragmentOverviewBinding.inflate(inflater)
        viewModel = ViewModelProvider(this).get(OverviewViewModel::class.java)

        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel

    //add recyclerview
    val viewAdapter = ItemAdapter({item->showDetail(item)})
    binding.recyclerView.adapter = viewAdapter

    viewModel.items.observe(viewLifecycleOwner, Observer{list->
        viewAdapter.submitList(list)
    })
        return binding.root
    }
    fun showDetail(username: String){
        Log.d("debug", "onClick " + username)
        // navigasi ke halaman lain
        this.findNavController()
            .navigate(OverviewFragmentDirections.actionOverviewFragmentToDetailFragment(username))
    }
}