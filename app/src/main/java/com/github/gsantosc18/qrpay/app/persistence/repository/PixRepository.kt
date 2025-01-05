package com.github.gsantosc18.qrpay.app.persistence.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.github.gsantosc18.qrpay.app.persistence.dao.PixDAO
import com.github.gsantosc18.qrpay.app.persistence.entity.PixEntity
import com.github.gsantosc18.qrpay.app.share.DB_NAME

@Database(entities = [PixEntity::class], version = 1)
abstract class PixRepository: RoomDatabase() {
    abstract fun pixDao(): PixDAO

    companion object {
        fun instance(context: Context): PixRepository =
            Room.databaseBuilder(context, PixRepository::class.java, DB_NAME)
                .allowMainThreadQueries()
                .build()
    }
}