package com.example.jetpackroom

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackroom.entity.Product
import com.example.jetpackroom.entity.Transact
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.text.SimpleDateFormat
import java.util.*

class DetailActivity : AppCompatActivity() {

    var myTransact: Transact? = null
    private fun getIdTransact(): Int = intent?.getIntExtra("data", 0) ?: 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.title = "Shooping Detail"

        doAsync {
            val db = AppDatabase.getInstance(this@DetailActivity).productDao()
            val products = db.allByTransact(getIdTransact())
            uiThread {
                list?.setListItem(products)
                if (products.isEmpty()) empty?.visibility = View.VISIBLE else {
                    amount?.text = "amount total: " + products.size
                    var money = 0
                    products.forEach {
                        money = money + (it.price * it.amount)
                    }
                    price?.text = "price total: " + money.toString()
                }
            }
        }

        doAsync {
            val db = AppDatabase.getInstance(this@DetailActivity).transactDao()
            val data = db.detail(getIdTransact())
            uiThread {
                myTransact = data
                name?.setText(myTransact?.nameTransact ?: "")
                created_date?.text = "created date: " + (myTransact?.createdDate ?: "-")
                updated_date?.text = "updated date: " + (myTransact?.updatedDate ?: "-")
            }
        }

        create?.setOnClickListener {
            openDialogCreate(getIdTransact())
        }
        update?.setOnClickListener {
            //TODO
        }
        delete?.setOnClickListener {
            openDialogDeleteTransact(myTransact)
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun getDate(): String {
        val sdf = SimpleDateFormat("dd/M/yyyy")
        return sdf.format(Date())
    }

    private fun RecyclerView.setListItem(items: List<Product>?) {
        layoutManager = LinearLayoutManager(context)
        hasFixedSize()
        adapter = ProductAdapter(items ?: emptyList()) {
            openDialogDeleteProduct(it)
        }
    }

    private fun openDialogCreate(transactId: Int) {
        val view = layoutInflater.inflate(R.layout.view_product_dialog, null, false)
        val etName = view.findViewById<TextView>(R.id.name)
        val etAmount = view.findViewById<TextView>(R.id.amount)
        val etPrice = view.findViewById<TextView>(R.id.price)
        val btnSave = view.findViewById<TextView>(R.id.save)

        val dialog = Dialog(view.context)
        dialog.setContentView(view)
        btnSave?.setOnClickListener {
            val name = etName?.text.toString().trim()
            val amount = etAmount?.text.toString().trim()
            val price = etPrice?.text.toString().trim()
            doAsync {
                val db = AppDatabase.getInstance(this@DetailActivity).productDao()
                try {
                    db.insert(
                        Product(
                            nameProduct = name,
                            amount = amount.toInt(),
                            price = price.toInt(),
                            transactId = transactId
                        )
                    )
                    uiThread {
                        Toast.makeText(this@DetailActivity, "Create Success", Toast.LENGTH_LONG)
                            .show()
                        restartActivity()
                    }
                } catch (e: Exception) {
                    uiThread {
                        Toast.makeText(this@DetailActivity, "Create Failed", Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }
        }

        dialog.show()
    }

    private fun openDialogDeleteTransact(transact: Transact?) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setMessage("Hapus Transaksi ini?")
            .setCancelable(false)
            .setCancelable(false)
            .setPositiveButton("OK") { _, _ ->
                doAsync {
                    val db = AppDatabase.getInstance(this@DetailActivity).transactDao()
                    try {
                        if (transact != null) {
                            db.delete(transact)
                            uiThread {
                                Toast.makeText(
                                    this@DetailActivity,
                                    "Delete Success",
                                    Toast.LENGTH_LONG
                                ).show()
                                finish()
                            }
                        } else {
                            uiThread {
                                Toast.makeText(
                                    this@DetailActivity,
                                    "Delete Failed",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                    } catch (e: Exception) {
                        uiThread {
                            Toast.makeText(this@DetailActivity, "Delete Failed", Toast.LENGTH_LONG)
                                .show()
                        }
                    }
                }
            }
            .setNegativeButton("Cancel") { _, _ ->
            }
        val alert: AlertDialog = builder.create()
        alert.show()
    }

    private fun openDialogDeleteProduct(product: Product) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setMessage("Hapus Item ini?")
            .setCancelable(false)
            .setPositiveButton("OK") { _, _ ->
                doAsync {
                    val db = AppDatabase.getInstance(this@DetailActivity).productDao()
                    try {
                        db.delete(product)
                        uiThread {
                            Toast.makeText(this@DetailActivity, "Delete Success", Toast.LENGTH_LONG)
                                .show()
                            restartActivity()
                        }
                    } catch (e: Exception) {
                        uiThread {
                            Toast.makeText(this@DetailActivity, "Delete Failed", Toast.LENGTH_LONG)
                                .show()
                        }
                    }
                }
            }
            .setNegativeButton("Cancel") { _, _ ->
            }
        val alert: AlertDialog = builder.create()
        alert.show()
    }

    private fun restartActivity() {
        finish()
        startActivity(intent)
    }
}