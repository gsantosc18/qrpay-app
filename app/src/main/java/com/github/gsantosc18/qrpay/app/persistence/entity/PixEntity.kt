package com.github.gsantosc18.qrpay.app.persistence.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "pix")
data class PixEntity(
    @PrimaryKey val id: UUID,
    @ColumnInfo(name = "key") val key: String,
    @ColumnInfo(name = "merchant_name") val merchantName: String,
    @ColumnInfo(name = "merchant_city") val merchantCity: String
)
