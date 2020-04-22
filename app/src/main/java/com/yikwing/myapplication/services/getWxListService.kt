package com.yikwing.myapplication.services

import com.yikwing.baselibrary.BaseHttpResult
import com.yikwing.myapplication.bean.WxListBean
import retrofit2.http.GET


interface getWxListService {
    @GET("/wxarticle/chapters/json")
    suspend fun getWxList(): BaseHttpResult<List<WxListBean>>
}