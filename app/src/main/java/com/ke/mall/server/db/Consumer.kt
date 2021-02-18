package com.ke.mall.server.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "consumers")
data class Consumer(
    /**
     * 用户id
     */
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    /**
     * 电话号码
     */
    val phone: String,
    /**
     * 密码，这里用的是md5摘要，在服务端请使用加盐算法
     */
    val password: String,

    /**
     * 是否启用
     */
    val enable: Boolean = true,
    /**
     * 是否被ban
     */
    val ban: Boolean = false,

    /**
     * 被ban的原因
     */
    @ColumnInfo(name = "ban_reason")
    val banReason: String? = null,

    /**
     * 被ban的结束日期
     */
    @ColumnInfo(name = "ban_end_date")
    val banEndDate: Date = Date()
)
