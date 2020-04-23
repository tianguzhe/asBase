package com.yikwing.myapplication.network

import com.readystatesoftware.chuck.ChuckInterceptor
import com.yikwing.baselibrary.BaseHttpResult
import com.yikwing.baselibrary.network.AddCookiesInterceptor
import com.yikwing.baselibrary.network.ReceivedCookiesInterceptor
import com.yikwing.myapplication.MyApp
import com.yikwing.myapplication.bean.WxListBean
import com.yikwing.myapplication.services.getWxListService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitFactory private constructor() {

    private var retrofit: Retrofit

    companion object {
        val instance by lazy {
            RetrofitFactory()
        }
    }

    init {
        retrofit = Retrofit.Builder()
            .baseUrl("http://www.wanandroid.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(initClient())
            .build()
    }

    private fun initClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(ChuckInterceptor(MyApp.instance()))
            .addInterceptor(AddCookiesInterceptor())
            .addInterceptor(ReceivedCookiesInterceptor())
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    suspend fun getWxList(): BaseHttpResult<List<WxListBean>> {
        return retrofit.create(getWxListService::class.java).getWxList()
    }

}