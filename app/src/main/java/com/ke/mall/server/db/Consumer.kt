package com.ke.mall.server.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "consumers")
data class Consumer(
    /**
     * 用户id
     */
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    /**
     * 账号
     */
    val account: String,
    val password: String,
    /**
     * 昵称
     */
    val nickname: String,
    /**
     * 是否是plus会员
     */
    val plus: Boolean,
    /**
     * 头像
     */
    @ColumnInfo(name = "avatar_url")
    val avatarUrl: String?,
    /**
     * 积分
     */
    val score: Int,

    /**
     * 是否启用
     */
    val enable: Boolean,
    /**
     * 是否被ban
     */
    val ban: Boolean,

    @ColumnInfo(name = "ban_reason")
    val banReason: String?
)
