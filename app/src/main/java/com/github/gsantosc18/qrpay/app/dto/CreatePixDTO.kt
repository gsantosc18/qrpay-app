package com.github.gsantosc18.qrpay.app.dto

import com.github.gsantosc18.qrpay.app.persistence.entity.PixEntity
import java.util.UUID

data class CreatePixDTO(
    val key: String,
    val merchantName: String,
    val merchantCity: String
) {
    fun entity(): PixEntity =
        PixEntity(
            id = UUID.randomUUID(),
            key = key,
            merchantName = merchantName,
            merchantCity = merchantCity
        )
}
