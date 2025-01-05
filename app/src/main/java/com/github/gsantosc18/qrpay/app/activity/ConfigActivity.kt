package com.github.gsantosc18.qrpay.app.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.gsantosc18.qrpay.app.R

class ConfigActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeButtonEnabled(true)
        }
    }
}