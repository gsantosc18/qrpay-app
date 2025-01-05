package com.github.gsantosc18.qrpay.app.command

interface Command<T> {
    fun execute(): T
}