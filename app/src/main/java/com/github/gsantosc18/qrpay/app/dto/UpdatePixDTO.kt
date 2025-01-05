package com.github.gsantosc18.qrpay.app.dto

import com.github.gsantosc18.qrpay.app.persistence.entity.PixEntity
import java.util.UUID

data class UpdatePixDTO(
    val id: UUID,
    val merchantName: String,
    val merchantCity: String,
    val key: String
) {
    fun toEntity(): PixEntity =
        PixEntity(
            id = id,
            key = key,
            merchantName = merchantName,
            merchantCity = merchantCity
        )
}
