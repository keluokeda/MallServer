package com.ke.mall.server.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Consumer::class], version = 1)
abstract class MallServerDatabase : RoomDatabase() {

    abstract fun consumerDao(): ConsumerDao


    companion object {
        private var _instance: MallServerDatabase? = null

        @Synchronized
        fun getInstance(context: Context): MallServerDatabase {
            if (_instance == null) {
                _instance =
                    Room.databaseBuilder(context, MallServerDatabase::class.java, "mall").build()
            }
            return _instance!!
        }

    }
}