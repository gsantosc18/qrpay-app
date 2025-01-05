package com.github.gsantosc18.qrpay.app.service.impl

import android.graphics.Bitmap
import com.github.gsantosc18.qrpay.app.command.GenerateQRCodeCommand
import com.github.gsantosc18.qrpay.app.command.recipe.QRCodeReceive
import com.github.gsantosc18.qrpay.app.dto.PixItemDTO
import com.github.gsantosc18.qrpay.app.service.QRCodeService
import java.math.BigDecimal

object QRCodeServiceImpl: QRCodeService {
    override fun generate(pix: PixItemDTO, value: BigDecimal): Bitmap =
        GenerateQRCodeCommand(
            qrCodeReceive = QRCodeReceive(
                key = pix.key,
                merchantName = pix.merchantName,
                merchantCity = pix.merchantCity,
                amount = BigDecimal(value.toString())
            ),
            width = 300,
            height = 300
        ).execute()
}