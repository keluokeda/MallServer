package com.ke.mall.server.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ConsumerDao {
    @Insert
    fun insert(consumer: Consumer): Long

    @Query("select * from consumers where phone = :phone")
    fun findByPhone(phone: String): Consumer?
}