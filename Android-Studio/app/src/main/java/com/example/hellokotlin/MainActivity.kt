package com.example.hellokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.databinding.DataBindingUtil
import com.example.hellokotlin.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

//        val button : Button = findViewById(R.id.btn1)
//        var text1 : TextView = findViewById(R.id.text1)
//        var input : EditText = findViewById(R.id.input)
//        var image : ImageView = findViewById(R.id.imageView)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btn1.setOnClickListener{
//            Toast.makeText(this@MainActivity, "Berhasil di Buat", Toast.LENGTH_SHORT).show()
//            btn1.setText("Change")
            val name = binding.input.text.toString()
            if (name == null || name.trim() == "") {
                Toast.makeText(
                    this@MainActivity, "tidak boleh kosong",
                    Toast.LENGTH_SHORT).show()
            }else {
                binding.text1.setText(name)
                var img = resources.getIdentifier(name, "drawable", packageName)
                binding.imageView.setImageResource(img)
            }
        }
    }
}