package com.example.jetpackroom.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Transact constructor(
    nameTransact: String,
    createdDate: String,
    updatedDate: String
) {

    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0

    @ColumnInfo(name = "name_transact")
    var nameTransact: String = nameTransact

    @ColumnInfo(name = "created_date")
    var createdDate: String = createdDate

    @ColumnInfo(name = "updated_date")
    var updatedDate: String? = updatedDate
}