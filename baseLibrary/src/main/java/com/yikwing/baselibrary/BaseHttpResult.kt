package com.yikwing.baselibrary

data class BaseHttpResult<T>(

    var data: T,
    var errorMsg: String,
    var errorCode: Int

)