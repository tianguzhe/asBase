package com.yikwing.myapplication.bean

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class WxListBean(
    @PrimaryKey
    var id: Int,
    var name: String,
    var order: Int,
    var parentChapterId: Int,
    var userControlSetTop: Boolean,
    var visible: Int
)