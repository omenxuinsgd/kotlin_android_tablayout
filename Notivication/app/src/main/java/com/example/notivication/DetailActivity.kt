package com.example.notivication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.notivication.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_detail)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        supportActionBar?.title = "Detail Data"
        supportActionBar?.subtitle = "Data yang sudah di inputkan"

        val bundle = intent.extras
        binding.namaTxt.text = (bundle?.getCharSequence(MainActivity.nama))
        binding.asalTxt.text = (bundle?.getCharSequence(MainActivity.asal))
        binding.companyTxt.text = (bundle?.getCharSequence(MainActivity.company))
        binding.phoneTxt.text = (bundle?.getCharSequence(MainActivity.phone))
        binding.hobyTxt.text = (bundle?.getCharSequence(MainActivity.hoby))

    }
}