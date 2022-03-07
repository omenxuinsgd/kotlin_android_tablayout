package com.example.jetpackroom

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackroom.entity.Transact
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "My Shooping List"

        create?.setOnClickListener {
            openDialog()
        }
    }

    override fun onResume() {
        super.onResume()
        doAsync {
            val transacts = AppDatabase.getInstance(this@MainActivity).transactDao().all
            uiThread {
                list?.setListItem(transacts)
                if (transacts.isEmpty()) empty?.visibility = View.VISIBLE
            }
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun getDate(): String {
        val sdf = SimpleDateFormat("dd/M/yyyy")
        return sdf.format(Date())
    }

    private fun RecyclerView.setListItem(items: List<Transact>?) {
        layoutManager = LinearLayoutManager(context)
        hasFixedSize()
        adapter = TransactAdapter(items ?: emptyList()) {
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra("data", it.uid)
            startActivity(intent)
        }
    }

    private fun openDialog() {
        val view = layoutInflater.inflate(R.layout.view_transact_dialog, null, false)
        val etName = view.findViewById<TextView>(R.id.name)
        val btnSave = view.findViewById<TextView>(R.id.save)

        val dialog = Dialog(view.context)
        dialog.setContentView(view)
        btnSave?.setOnClickListener {
            val name = etName?.text.toString().trim()
            doAsync {
                val db = AppDatabase.getInstance(this@MainActivity).transactDao()
                try {
                    db.insert(
                        Transact(
                            nameTransact = name,
                            createdDate = getDate(),
                            updatedDate = "-"
                        )
                    )
                    uiThread {
                        Toast.makeText(this@MainActivity, "Create Success", Toast.LENGTH_LONG)
                            .show()
                        dialog.dismiss()
                        restartActivity()
                    }
                } catch (e: Exception) {
                    uiThread {
                        Toast.makeText(this@MainActivity, "Create Failed", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

        dialog.show()
    }

    private fun restartActivity() {
        finish()
        startActivity(intent)
    }
}