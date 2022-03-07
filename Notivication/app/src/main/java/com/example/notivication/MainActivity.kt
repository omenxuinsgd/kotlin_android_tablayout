package com.example.notivication

import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.notivication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    companion object{
        val nama: String? = ""
        val asal: String? = ""
        val phone: String? = ""
        val company: String? = ""
        val hoby: String? = ""
    }
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        Log.d(TAG, "MULAI")
        Log.e(TAG, "ERROR")
        Log.w(TAG, "WARM")
        Log.i(TAG, "INFO")
        Log.v(TAG, "VERBOSE")

//        TITTLE
        supportActionBar?.title = "Input Data"

//        Subtitle
        supportActionBar?.subtitle = "Learn Kotlin with Refactory"

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.button.setOnClickListener{
            if(binding.name.text.isEmpty() || binding.address.text.isEmpty() ||
                binding.phone.text.isEmpty() || binding.company.text.isEmpty() ||
                binding.hoby.text.isEmpty()){
                Toast.makeText(this, "text tidak boleh kosong",
                    Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "sukses",
                    Toast.LENGTH_LONG).show()
                val intent = Intent(this, DetailActivity::class.java)
                var bundle = Bundle()

                bundle.putString(nama, binding.name.text.toString())
                bundle.putString(asal, binding.address.text.toString())
                bundle.putString(phone, binding.phone.text.toString())
                bundle.putString(company, binding.company.text.toString())
                bundle.putString(nama, binding.hoby.text.toString())

                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }
}