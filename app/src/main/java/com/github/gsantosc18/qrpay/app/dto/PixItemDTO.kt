package com.github.gsantosc18.qrpay.app.dto

import com.github.gsantosc18.qrpay.app.persistence.entity.PixEntity
import java.util.UUID

data class PixItemDTO(
    val id: UUID?,
    val key: String,
    val merchantName: String,
    val merchantCity: String
) {
    companion object {
        fun from(pixEntity: PixEntity): PixItemDTO =
            with(pixEntity) {
                PixItemDTO(
                    id,key, merchantName, merchantCity
                )
            }
    }
}
