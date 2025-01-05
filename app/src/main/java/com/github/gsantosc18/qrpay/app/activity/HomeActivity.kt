package com.github.gsantosc18.qrpay.app.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.github.gsantosc18.qrpay.app.R

class HomeActivity : AppCompatActivity() {
    private lateinit var valueInput: EditText
    private lateinit var generateBtn : Button
    private lateinit var bottomSideFrame: FrameLayout

    private val valuesBtn = listOf(
        R.id.tenValueBtn,
        R.id.twentValueBtn,
        R.id.fiftyValueBtn,
        R.id.hundredValueBtn,
        R.id.twoHundredValueBtn
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setTitle(R.string.home)

        valueInput = findViewById(R.id.valueInput)
        generateBtn = findViewById(R.id.generateBtn)
        bottomSideFrame = findViewById(R.id.bottomSideFrame)

        generateBtn.setOnClickListener(actionGenerateBtnClick())
        valueInput.onFocusChangeListener = changeValueInput()

        valuesBtn.forEach {
            val value = findViewById<Button>(it)
            value.setOnClickListener {
                valueInput.setText(value.text.toString())
            }
        }
    }

    private fun actionGenerateBtnClick(): View.OnClickListener =
        View.OnClickListener {
            Intent(this, QRCodeActivity::class.java)
                .apply { putExtra("value", valueInput.text.toString()) }
                .also(::startActivity)
        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_top_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.home_top_menu_config) {
            Intent(this, PixActivity::class.java)
                .also(::startActivity)
        }
        return true
    }

    private fun changeValueInput() = View.OnFocusChangeListener { _, hasFocus ->
        bottomSideFrame.visibility = when (hasFocus) {
            true -> View.VISIBLE
            else -> View.INVISIBLE
        }
    }
}