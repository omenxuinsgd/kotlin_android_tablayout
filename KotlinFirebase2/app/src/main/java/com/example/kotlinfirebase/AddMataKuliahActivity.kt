package com.example.kotlinfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_add_mata_kuliah.*
import kotlinx.android.synthetic.main.activity_main.*

class AddMataKuliahActivity : AppCompatActivity() {
//    private lateinit var tvNama: TextView
//    private lateinit var etMatkul: EditText
//    private lateinit var etSks : EditText
//    private lateinit var btnMatkul : Button
//    private lateinit var lvMatkul : ListView
    private lateinit var matkulList: MutableList<MataKuliah>
    private lateinit var ref: DatabaseReference

    companion object{
        const val EXTRA_NAMA = "extra_nama"
        const val EXTRA_ID = "extra_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_mata_kuliah)

        val id : String? = intent.getStringExtra(EXTRA_ID)
        val nama : String? = intent.getStringExtra(EXTRA_NAMA)

        matkulList = mutableListOf()
        ref = FirebaseDatabase.getInstance().getReference("mata kuliah").child(id!!)
        btn_matkul.setOnClickListener{
            saveMatkul()
        }
    }

    private fun saveMatkul() {
        val namaMatkul: String = et_matkul.text.toString().trim()
        val sksText: String = et_sks.text.toString()
        val sks: Int = sksText.toInt()

        if(namaMatkul.isEmpty() && sksText.isEmpty()){
            et_matkul.error = "isi Nama!"
            et_sks.error = "isi Umur!"
            return
        }
        val matkulId: String? = ref.push().key
        val matkul = MataKuliah(matkulId!!, namaMatkul, sks)

        if(matkulId != null){
            ref.child(matkulId).setValue(matkul).addOnCompleteListener{
                Toast.makeText(this@AddMataKuliahActivity,
                "Berhasil Menyimpan Data", Toast.LENGTH_SHORT).show()}
        }
        ref.addValueEventListener(object: ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    matkulList.clear()
                    for(h in snapshot.children){
                        val mataKuliah: MataKuliah? = h.getValue(MataKuliah::class.java)
                        if (mataKuliah != null) {
                            matkulList.add(mataKuliah)
                        }
                    }
                    val adapter = MataKuliahAdapter(this@AddMataKuliahActivity, R.layout.item_matkul, matkulList)
                    lv_matkul.adapter = adapter
                }
            }
        })
    }
}