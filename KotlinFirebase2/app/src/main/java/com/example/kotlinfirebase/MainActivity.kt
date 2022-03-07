package com.example.kotlinfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
//    lateinit var button : Button
    private lateinit var ref : DatabaseReference
    private lateinit var mhsList: MutableList<Mahasiswa>
    private lateinit var listMhs: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ref = FirebaseDatabase.getInstance().getReference("Mahasiswa")
        button.setOnClickListener(this)

        mhsList = mutableListOf()
        listMhs = lv_mhs

        ref.addValueEventListener(object: ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    mhsList.clear()
                    for(h in snapshot.children){
                        val mahasiswa = h.getValue(Mahasiswa::class.java)
                        if (mahasiswa != null) {
                            mhsList.add(mahasiswa)
                        }
                    }
                    val adapter = MahasiswaAdapter(this@MainActivity, R.layout.item_mhs, mhsList)
                    listMhs.adapter = adapter
                }
            }
        })
        listMhs.setOnItemClickListener{ parent, view, position, id ->
            val mahasiswa: Mahasiswa = mhsList.get(position)
            val intent = Intent(this@MainActivity, AddMataKuliahActivity::class.java)
            intent.putExtra(AddMataKuliahActivity.EXTRA_ID, mahasiswa.id)
            intent.putExtra(AddMataKuliahActivity.EXTRA_NAMA, mahasiswa.nama)
            startActivity(intent)
        }
    }

    override fun onClick(v: View?) {
        saveData()
    }

    private fun saveData() {
        val nama: String = etName.text.toString().trim()
        val age: String = etAge.text.toString().trim()

        if(nama.isEmpty() && age.isEmpty()){
            etName.error = "isi Nama!"
            etAge.error = "isi Umur!"
            return
        }

        val mhsId: String? = ref.push().key
        val mhs = Mahasiswa(mhsId!!, nama, age)

        if(mhsId != null){
            ref.child(mhsId).setValue(mhs).addOnCompleteListener{Toast.makeText(this@MainActivity,
            "Berhasil Menyimpan Data", Toast.LENGTH_SHORT).show()}
        }
    }
}
