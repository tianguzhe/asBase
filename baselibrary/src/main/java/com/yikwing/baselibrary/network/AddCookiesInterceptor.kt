package com.yikwing.baselibrary.network

import com.blankj.utilcode.util.SPUtils
import okhttp3.Interceptor
import okhttp3.Response

//添加cookies
class AddCookiesInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()

        val preferences = SPUtils.getInstance("cookies").getStringSet("cookie", null)

        if (preferences != null) {
            for (cookie in preferences) {
                builder.addHeader("Cookie", cookie)
            }
        }

        return chain.proceed(builder.build())
    }
}