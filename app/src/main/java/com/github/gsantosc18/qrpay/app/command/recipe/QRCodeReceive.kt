package com.github.gsantosc18.qrpay.app.command.recipe

import com.github.gsantosc18.qrpay.dto.PixDTO
import java.math.BigDecimal

data class QRCodeReceive(
    val amount: BigDecimal,
    val key: String,
    val merchantCity: String,
    val merchantName: String
) {
    fun toDTO(): PixDTO = PixDTO(
        key = key,
        amount = amount,
        merchantName = merchantName,
        merchantCity = merchantCity
    )
}
