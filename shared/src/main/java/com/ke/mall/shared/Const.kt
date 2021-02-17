package com.ke.mall.shared

import android.provider.BaseColumns

object Const {

    object Consumer {
        const val TABLE_NAME = "consumers"
        const val COLUMN_ID = BaseColumns._ID
        const val COLUMN_ACCOUNT = "account"
        const val COLUMN_PASSWORD = "password"
        const val COLUMN_NICKNAME = "nickname"
        const val COLUMN_PLUS = "plus"
        const val COLUMN_AVATAR_URL = "avatar_url"
        const val COLUMN_SCORE = "score"


    }

}