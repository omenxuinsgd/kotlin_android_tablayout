package com.example.kotlinfirebase

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MahasiswaAdapter(val nCtx: Context, val layoutResId: Int, val mhsList: MutableList<Mahasiswa>) :
    ArrayAdapter<Mahasiswa>(nCtx, layoutResId, mhsList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(nCtx)
        val view: View = layoutInflater.inflate(layoutResId, null)

        val tvNama: TextView = view.findViewById(R.id.tv_nama)
        val tvAge: TextView = view.findViewById(R.id.tv_age)
        val tvEdit: TextView = view.findViewById(R.id.tv_edit)
        val mahasiswa: Mahasiswa = mhsList[position]
        tvEdit.setOnClickListener{
            showUpdateDialog(mahasiswa)
        }
        tvNama.text = mahasiswa.nama
        tvAge.text = mahasiswa.age

        return view
    }

    private fun showUpdateDialog(mahasiswa: Mahasiswa) {
        val builder = AlertDialog.Builder(nCtx)
        builder.setTitle("edit data")
        val inflater: LayoutInflater = LayoutInflater.from(nCtx)
        val view: View = inflater.inflate(R.layout.update_dialog, null)

        val etNama: TextView = view.findViewById(R.id.et_name)
        val etAge: TextView = view.findViewById(R.id.et_age)
        etNama.setText(mahasiswa.nama)
        etAge.setText(mahasiswa.age)
        builder.setView(view)
        builder.setPositiveButton("Update"){ p0, p1 ->
            val dbMhs: DatabaseReference = FirebaseDatabase.getInstance().getReference("mahasiswa")
            val nama: String = etNama.text.toString().trim()
            val age: String = etAge.text.toString().trim()

            if(nama.isEmpty() && age.isEmpty()){
                etNama.error = "isi namanya dong!"
                etAge.error = "isi umurnya dong!"
                etNama.requestFocus()
                etAge.requestFocus()
                return@setPositiveButton
            }

            val mahasiswa: Mahasiswa = Mahasiswa(mahasiswa.id, nama, age)
            dbMhs.child(mahasiswa.id!!).setValue(mahasiswa)

            Toast.makeText(nCtx, "Data Berhasil Diupdate", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("Cancel"){
            p0, p1 ->
        }

        val alert: AlertDialog = builder.create()
        alert.show()
    }
}