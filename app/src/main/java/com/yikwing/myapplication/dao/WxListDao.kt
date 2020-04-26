package com.yikwing.myapplication.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.yikwing.myapplication.bean.WxListBean


@Dao()
interface WxListDao {

    @Insert
    fun insertAll(vararg wxListBean: WxListBean)

    @Query("SELECT * FROM wxlistbean")
    fun getAll(): List<WxListBean>

    @Query("SELECT * FROM wxlistbean WHERE id = :id ")
    fun findById(id: Int): WxListBean?

}