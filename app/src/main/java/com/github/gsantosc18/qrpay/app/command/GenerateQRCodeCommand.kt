package com.github.gsantosc18.qrpay.app.command

import android.graphics.Bitmap
import android.graphics.Color
import android.util.Log
import com.github.gsantosc18.qrpay.app.command.recipe.QRCodeReceive
import com.github.gsantosc18.qrpay.service.PixCodeService
import com.github.gsantosc18.qrpay.service.QRCodeService

class GenerateQRCodeCommand(
    private val qrCodeReceive: QRCodeReceive,
    private val width: Int,
    private val height: Int
): Command<Bitmap> {
    override fun execute(): Bitmap {
        val code = PixCodeService.generate(qrCodeReceive.toDTO())
        Log.i(this::class.simpleName, "Generate code: $code")
        val qrCode = QRCodeService.generate(
            code = code,
            width = width,
            height = height
        )
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
        for (x in 0 until width) {
            for (y in 0 until height) {
                bitmap.setPixel(x, y, if (qrCode[x, y]) Color.BLACK else Color.WHITE)
            }
        }
        return bitmap
    }
}