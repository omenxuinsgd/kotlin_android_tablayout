package com.example.kotlinfirebase

data class Mahasiswa (
    val id: String,
    val nama: String,
    val age: String
        ){
    constructor(): this("", "", "")
}