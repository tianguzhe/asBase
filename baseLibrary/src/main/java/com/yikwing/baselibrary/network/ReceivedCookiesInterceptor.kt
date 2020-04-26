package com.yikwing.baselibrary.network

import com.blankj.utilcode.util.SPUtils
import okhttp3.Interceptor
import okhttp3.Response


//获取cookies
class ReceivedCookiesInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalResponse = chain.proceed(chain.request())

        if (originalResponse.headers("Set-Cookie").isNotEmpty()) {
            val cookies = HashSet<String>()

            for (header in originalResponse.headers("Set-Cookie")) {
                cookies.add(header)
            }

            SPUtils.getInstance("cookies").put("cookie", cookies)

        }

        return originalResponse
    }
}