package com.yikwing.myapplication.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.yikwing.myapplication.bean.WxListBean


@Database(entities = [WxListBean::class], version = 1)
abstract class WxListDatabase : RoomDatabase() {

    abstract fun wxListdDao(): WxListDao

    companion object {

        @Volatile
        private var instance: WxListDatabase? = null

        fun getInstance(context: Context): WxListDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): WxListDatabase {
            return Room.databaseBuilder(context, WxListDatabase::class.java, "database-name")
                .build()
        }
    }

}