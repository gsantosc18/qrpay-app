package com.github.gsantosc18.qrpay.app.service

import com.github.gsantosc18.qrpay.app.dto.CreatePixDTO
import com.github.gsantosc18.qrpay.app.dto.PixItemDTO
import com.github.gsantosc18.qrpay.app.dto.UpdatePixDTO

interface PixService {
    fun create(createPixDTO: CreatePixDTO)
    fun update(updatePixDTO: UpdatePixDTO)
    fun findFirst(): PixItemDTO?
}