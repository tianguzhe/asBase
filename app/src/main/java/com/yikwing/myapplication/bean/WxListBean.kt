package com.yikwing.myapplication.bean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class WxListBean(
    @PrimaryKey
    var id: Int,
    var name: String,
    @ColumnInfo(name = "bar_order")
    var order: Int,
    var parentChapterId: Int,
    var visible: Int
//    @ColumnInfo(name = "bar_data")
//    var bar: Int
)