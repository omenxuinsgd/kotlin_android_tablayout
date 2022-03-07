package com.example.kotlinfirebase

data class MataKuliah(
    val id: String,
    val nama: String,
    val sks: Int
){
    constructor(): this("", "", 0)
}