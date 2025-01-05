package com.github.gsantosc18.qrpay.app.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.github.gsantosc18.qrpay.app.R
import com.github.gsantosc18.qrpay.app.dto.CreatePixDTO
import com.github.gsantosc18.qrpay.app.dto.UpdatePixDTO
import com.github.gsantosc18.qrpay.app.service.PixService
import com.github.gsantosc18.qrpay.app.service.impl.PixServiceImpl
import com.github.gsantosc18.qrpay.app.share.showInfo
import com.github.gsantosc18.qrpay.app.share.whenNotNull
import java.util.UUID

class PixActivity : AppCompatActivity() {
    private lateinit var merchantNameInput: EditText
    private lateinit var merchantCityInput: EditText
    private lateinit var keyInput: EditText

    private lateinit var pixService: PixService
    private var pixId: UUID? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pix)
        setTitle(TITLE)

        supportActionBar?.apply {
            setHomeButtonEnabled(true)
            setDisplayHomeAsUpEnabled(true)
        }

        pixService = PixServiceImpl(this)

        merchantNameInput = findViewById(R.id.pixMerchantNameInput)
        merchantCityInput = findViewById(R.id.pixMerchantCityInput)
        keyInput = findViewById(R.id.pixKeyInput)

        loadPixData()

        val pixSaveBtn = findViewById<Button>(R.id.pixSaveBtn)
        pixSaveBtn.setOnClickListener{ persist() }
    }

    private fun persist() {
        when(pixId) {
            null -> create()
            else -> update()
        }
    }

    private fun loadPixData() {
        val pix = pixService.findFirst()
        whenNotNull(pix) {
            pixId = requireNotNull(id) { "Pix ID not found" }
            merchantNameInput.setText(merchantName)
            merchantCityInput.setText(merchantCity)
            keyInput.setText(key)
        }
    }

    private fun create() {
        val dto = CreatePixDTO(
            key = keyInput.text.toString(),
            merchantName = merchantNameInput.text.toString(),
            merchantCity = merchantCityInput.text.toString()
        )
        pixService.create(dto)
        showInfo(this, R.string.pix_create_message)
    }

    private fun update() {
        val dto = UpdatePixDTO(
            id = requireNotNull(pixId) { "Pix ID is required" },
            key = keyInput.text.toString(),
            merchantName = merchantNameInput.text.toString(),
            merchantCity = merchantCityInput.text.toString()
        )
        pixService.update(dto)
        showInfo(this, R.string.pix_update_message)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            Intent(this, HomeActivity::class.java)
                .also(::startActivity)
                .also { finishAffinity() }
        }
        return true
    }

    companion object {
        private val TITLE = R.string.pix
    }
}