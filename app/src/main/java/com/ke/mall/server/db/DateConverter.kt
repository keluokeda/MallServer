package com.ke.mall.server.db

import androidx.room.TypeConverter
import java.util.*

class DateConverter {
    @TypeConverter
    fun fromTime(time: Long) = Date(time)

    @TypeConverter
    fun dateToTime(date: Date) = date.time
}