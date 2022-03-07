package com.example.sharedpreference

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    var isRemembered = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        isRemembered = sharedPreferences.getBoolean("CHECKBOX", false)

        if(isRemembered) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        loginBtn.setOnClickListener {
            val name: String = nameTxt.text.toString()
            val age: Int = ageTxt.text.toString().toInt()
            val checked: Boolean = checkBox.isChecked

            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("NAME", name)
            editor.putInt("AGE", age)
            editor.putBoolean("CHECKED", checked)
            editor.apply()

            Toast.makeText(this, "Infromation Save", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}