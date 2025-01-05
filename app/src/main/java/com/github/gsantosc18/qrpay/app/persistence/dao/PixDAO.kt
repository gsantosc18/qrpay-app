package com.github.gsantosc18.qrpay.app.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.github.gsantosc18.qrpay.app.persistence.entity.PixEntity
import java.util.UUID

@Dao
interface PixDAO {
    @Insert(onConflict = REPLACE)
    fun save(pixEntity: PixEntity)

    @Query("SELECT * FROM pix WHERE id = :id LIMIT 1")
    fun findById(id: UUID): PixEntity?

    @Query("SELECT * FROM pix LIMIT 1")
    fun findFirst(): PixEntity?
}