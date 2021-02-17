package com.ke.mall.server.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ke.mall.shared.Const

@Dao
interface ConsumerDao {
    @Insert
    fun insert(consumer: Consumer)

    @Query("select * from " + Const.Consumer.TABLE_NAME + " where " + Const.Consumer.COLUMN_ACCOUNT + " = :account")
    fun findByAccount(account: String): Consumer?
}