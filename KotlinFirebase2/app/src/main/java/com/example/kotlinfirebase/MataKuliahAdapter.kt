package com.example.kotlinfirebase

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class MataKuliahAdapter(val nCtx: Context, val layoutResId: Int, val matkulList: List<MataKuliah>) :
    ArrayAdapter<MataKuliah>(nCtx, layoutResId, matkulList){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater: LayoutInflater = LayoutInflater.from(nCtx)
        val view: View = layoutInflater.inflate(layoutResId, null)

        val tvNamaMatkul: TextView = view.findViewById(R.id.tv_matkul)
        val tvSks: TextView = view.findViewById(R.id.tv_sks)

        val mataKuliah: MataKuliah = matkulList[position]

        tvNamaMatkul.text = mataKuliah.nama
        tvSks.text = mataKuliah.sks.toString()

        return view
    }
}