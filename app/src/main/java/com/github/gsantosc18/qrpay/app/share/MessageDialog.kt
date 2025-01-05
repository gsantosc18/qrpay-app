package com.github.gsantosc18.qrpay.app.share

import android.content.Context
import android.content.DialogInterface.OnClickListener
import com.github.gsantosc18.qrpay.app.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

private val OK: Int = R.string.ok_message

fun showInfo(context: Context, message: Int, ok: OnClickListener = ok()) {
    MaterialAlertDialogBuilder(context)
        .setPositiveButton(OK, ok)
        .setMessage(message)
        .create()
        .show()
}

fun ok(): OnClickListener = OnClickListener { dialog, _ -> dialog.dismiss() }