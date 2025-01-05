package com.github.gsantosc18.qrpay.app.service

import android.graphics.Bitmap
import com.github.gsantosc18.qrpay.app.dto.PixItemDTO
import java.math.BigDecimal

interface QRCodeService {
    fun generate(pix: PixItemDTO, value: BigDecimal): Bitmap
}