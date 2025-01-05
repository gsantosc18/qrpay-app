package com.github.gsantosc18.qrpay.app.service.impl

import android.content.Context
import com.github.gsantosc18.qrpay.app.dto.CreatePixDTO
import com.github.gsantosc18.qrpay.app.dto.PixItemDTO
import com.github.gsantosc18.qrpay.app.dto.UpdatePixDTO
import com.github.gsantosc18.qrpay.app.persistence.dao.PixDAO
import com.github.gsantosc18.qrpay.app.persistence.repository.PixRepository
import com.github.gsantosc18.qrpay.app.service.PixService

class PixServiceImpl(context: Context): PixService {
    private val pixDAO: PixDAO = PixRepository.instance(context).pixDao()

    override fun create(createPixDTO: CreatePixDTO) {
        pixDAO.save(createPixDTO.entity())
    }

    override fun update(updatePixDTO: UpdatePixDTO) {
        pixDAO.save(updatePixDTO.toEntity())
    }

    override fun findFirst(): PixItemDTO? =
        pixDAO.findFirst()?.let(PixItemDTO::from)
}