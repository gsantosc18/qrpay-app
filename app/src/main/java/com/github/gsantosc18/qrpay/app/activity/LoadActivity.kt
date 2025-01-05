package com.github.gsantosc18.qrpay.app.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.github.gsantosc18.qrpay.app.R
import com.github.gsantosc18.qrpay.app.share.WAIT_LAUNCHER

class LoadActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load)
        Thread {
            Thread.sleep(WAIT_LAUNCHER)
            Intent(this, HomeActivity::class.java)
                .apply {
                    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                .also(::startActivity)
        }.start()
    }
}