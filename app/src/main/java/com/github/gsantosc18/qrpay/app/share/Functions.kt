package com.github.gsantosc18.qrpay.app.share

import android.os.Bundle
import java.math.BigDecimal

inline fun <T: Any> whenNotNull(receiver: T?, block: T.() -> Unit) {
    receiver?.block()
}

fun Bundle.getBigDecimal(key: String): BigDecimal? =
    getString(key)
        ?.takeIf { it.isNotBlank() }
        ?.let { BigDecimal(it) }
