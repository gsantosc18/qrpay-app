package com.github.gsantosc18.qrpay.app.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.gsantosc18.qrpay.app.R
import com.github.gsantosc18.qrpay.app.dto.PixItemDTO
import com.github.gsantosc18.qrpay.app.service.PixService
import com.github.gsantosc18.qrpay.app.service.impl.PixServiceImpl
import com.github.gsantosc18.qrpay.app.service.impl.QRCodeServiceImpl
import com.github.gsantosc18.qrpay.app.share.getBigDecimal
import com.github.gsantosc18.qrpay.app.share.whenNotNull
import java.math.BigDecimal

class QRCodeActivity : AppCompatActivity() {

    private lateinit var pixService: PixService
    private var pixItemDTO: PixItemDTO? = null
    private lateinit var valueQRCodeInput: TextView
    private lateinit var qrCodeImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrcode)
        setTitle(TITLE)

        valueQRCodeInput = findViewById(R.id.valueQRCode)
        qrCodeImage = findViewById(R.id.qrCodeView)
        pixService = PixServiceImpl(this)

        supportActionBar?.apply{
            setDisplayHomeAsUpEnabled(true)
            setHomeButtonEnabled(true)
        }

        val receivedValue: BigDecimal? = intent.extras?.getBigDecimal("value")

        if (receivedValue == null){
            Toast.makeText(this, PIX_VALUE_NOT_FOUND, Toast.LENGTH_LONG).show()
            goHome()
            return
        }

        valueQRCodeInput.text = "$receivedValue"

        pixItemDTO = pixService.findFirst()

        if (pixItemDTO == null) {
            Toast.makeText(this, PIX_NOT_FOUND, Toast.LENGTH_LONG).show()
            goHome()
            return
        }

        whenNotNull(receivedValue) {
            val bitmap = QRCodeServiceImpl.generate(requireNotNull(pixItemDTO), this)
            qrCodeImage.setImageBitmap(bitmap)
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == HOME_ID) {
            goHome()
        }
        return true
    }

    private fun goHome() {
        Intent(this, HomeActivity::class.java)
            .also(::startActivity)
            .also { finishAffinity() }
    }

    companion object {
        private const val HOME_ID = android.R.id.home
        private val TITLE = R.string.qrcode
        private val PIX_NOT_FOUND = R.string.pix_not_found
        private val PIX_VALUE_NOT_FOUND = R.string.pix_value_not_found
    }
}