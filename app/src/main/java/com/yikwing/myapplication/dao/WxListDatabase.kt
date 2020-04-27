package com.yikwing.myapplication.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.yikwing.myapplication.bean.WxListBean


@Database(entities = [WxListBean::class], version = 3, exportSchema = false)
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
                .addMigrations(
                    // 要先在Bean里添加字段( $ bar_data)
                    object : Migration(1, 2) {
                        override fun migrate(database: SupportSQLiteDatabase) {
                            database.execSQL("ALTER TABLE wxlistbean ADD COLUMN bar_data INTEGER NOT NULL DEFAULT 10")
                        }
                    }
                )
                .addMigrations(object : Migration(2, 3) {
                    override fun migrate(database: SupportSQLiteDatabase) {
                        database.execSQL("CREATE TABLE tmp (id INTEGER PRIMARY KEY NOT NULL, name TEXT NOT NULL , bar_order INTEGER NOT NULL, parentChapterId INTEGER NOT NULL, visible INTEGER NOT NULL)")
                        database.execSQL("INSERT INTO tmp (id,name,bar_order,parentChapterId,visible) SELECT id,name,bar_order,parentChapterId,visible FROM wxlistbean")
                        database.execSQL("DROP TABLE wxlistbean")
                        database.execSQL("ALTER TABLE tmp RENAME TO wxlistbean")
                    }
                })
                .build()
        }
    }
}