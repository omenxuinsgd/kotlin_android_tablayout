package com.example.jetpackroom.entity

import androidx.room.*

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Transact::class,
            parentColumns = arrayOf("uid"),
            childColumns = arrayOf("transact_id"),
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["transact_id"])]
)
class Product constructor(nameProduct: String, amount: Int, price: Int, transactId: Int) {

    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0

    @ColumnInfo(name = "name_product")
    var nameProduct: String = nameProduct

    @ColumnInfo(name = "amount")
    var amount: Int = amount

    @ColumnInfo(name = "price")
    var price: Int = price

    @ColumnInfo(name = "transact_id")
    var transactId: Int? = transactId
}