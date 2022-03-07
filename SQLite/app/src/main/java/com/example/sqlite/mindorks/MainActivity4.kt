package com.example.sqlite.mindorks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sqlite.R
import kotlinx.android.synthetic.main.activity_main4.*

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        btnAddToDb.setOnClickListener {
            val dbHandler = MindOrksDBOpenHelper(this, null)
            val user = Name(etName.text.toString())
            dbHandler.addName(user)
            Toast.makeText(this, etName.text.toString() + "Added to database", Toast.LENGTH_LONG)
                .show()
        }
        btnShowDatafromDb.setOnClickListener {
            tvDisplayName.text = ""
            val dbHandler = MindOrksDBOpenHelper(this, null)
            val cursor = dbHandler.getAllName()
            cursor!!.moveToFirst()
            tvDisplayName.append((cursor.getString(cursor.getColumnIndex(MindOrksDBOpenHelper.COLUMN_NAME))))
            while (cursor.moveToNext()) {
                tvDisplayName.append((cursor.getString(cursor.getColumnIndex(MindOrksDBOpenHelper.COLUMN_NAME))))
                tvDisplayName.append("\n")
            }
            cursor.close()
        }
    }
}