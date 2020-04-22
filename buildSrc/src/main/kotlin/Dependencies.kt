object Versions {
    //build conf
    val compileSdkVersion = 29
    val buildToolsVersion = "29.0.3"
    val minSdkVersion = 21
    val targetSdkVersion = 29
    val versionCode = 1
    val versionName = "1.0"

    // default conf
    val adxCoreKtx = "1.2.0"
    val adxAppcompat = "1.1.0"
    val adxAnnotation = "1.1.0"
    val adxConstraintlayout = "1.1.3"
    val adxRecyclerView = "1.1.0"
    val adxViewPage = "1.0.0"
    val adxViewPage2 = "1.0.0"
    val googleMaterial = "1.2.0-alpha06"
    val adxActivity = "1.2.0-alpha03"
    val adxFragmentKtx = "1.3.0-alpha03"

    //kotlin conf
    val kotlin = "1.3.72"
    val kotlinCoroutines = "1.3.5"

    // base
    val gsonVersion = "2.8.6"
    val glide = "4.11.0"
    val BaseRecyclerView = "3.0.3"
    val logger = "2.2.0"
    val utils = "1.28.1"

    // 路由
    val arouterApi = "1.5.0"
    val arouterCompiler = "1.2.2"
    val arouterRegister = "1.0.2"

    // network
    val okhttp = "4.5.0"
    val retrofitVersion = "2.8.1"
}

object AsLibs {

    // default support
    val adxCoreKtx = "androidx.core:core-ktx:${Versions.adxCoreKtx}"
    val adxAppcompat = "androidx.appcompat:appcompat:${Versions.adxAppcompat}"
    val adxAnnotation = "androidx.annotation:annotation:${Versions.adxAnnotation}"
    val adxConstraintlayout =
        "androidx.constraintlayout:constraintlayout:${Versions.adxConstraintlayout}"
    val adxRecyclerView = "androidx.recyclerview:recyclerview:${Versions.adxRecyclerView}"
    val adxViewPage = "androidx.viewpager:viewpager:${Versions.adxViewPage}"
    val adxViewPage2 = "androidx.viewpager2:viewpager2:${Versions.adxViewPage2}"
    val googleMaterial = "com.google.android.material:material:${Versions.googleMaterial}"
    val adxActivity = "androidx.activity:activity:${Versions.adxActivity}"
    val adxFragmentKtx = "androidx.fragment:fragment-ktx:${Versions.adxFragmentKtx}"

    // base
    val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    val BaseRecyclerView =
        "com.github.CymChad:BaseRecyclerViewAdapterHelper:${Versions.BaseRecyclerView}"
    val logger = "com.orhanobut:logger:${Versions.logger}"
    val utils = "com.blankj:utilcodex:${Versions.utils}"

    // 协程
    val kotlinCoroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
    val kotlinCoroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"

    // 路由
    val arouterApi = "com.alibaba:arouter-api:${Versions.arouterApi}"
    val arouterCompiler = "com.alibaba:arouter-compiler:${Versions.arouterCompiler}"
    val arouterRegister = "com.alibaba:arouter-register:${Versions.arouterRegister}"

    // network
    val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    val retrofitConverters = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
}