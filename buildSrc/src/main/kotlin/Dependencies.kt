object Versions {
    //build conf
    const val compileSdkVersion = 29
    const val buildToolsVersion = "29.0.3"
    const val minSdkVersion = 21
    const val targetSdkVersion = 29
    const val versionCode = 1
    const val versionName = "1.0"

    // default conf
    const val adxCoreKtx = "1.2.0"
    const val adxAppcompat = "1.1.0"
    const val adxAnnotation = "1.1.0"
    const val adxConstraintlayout = "1.1.3"
    const val adxRecyclerView = "1.1.0"
    const val adxViewPage = "1.0.0"
    const val adxViewPage2 = "1.0.0"
    const val googleMaterial = "1.2.0-alpha06"
    const val adxActivity = "1.2.0-alpha03"
    const val adxFragmentKtx = "1.3.0-alpha03"
    const val room_version = "2.2.5"
    const val debug_db = "1.0.6"

    //kotlin conf
    const val kotlin = "1.3.72"
    const val kotlinCoroutines = "1.3.5"

    // base
    const val gsonVersion = "2.8.6"
    const val glide = "4.11.0"
    const val BaseRecyclerView = "3.0.3"
    const val logger = "2.2.0"
    const val utils = "1.28.1"
    const val leakcanary = "2.2"

    // 路由
    const val arouterApi = "1.5.0"
    const val arouterCompiler = "1.2.2"
    const val arouterRegister = "1.0.2"

    // network
    const val okhttp = "4.5.0"
    const val retrofitVersion = "2.8.1"
}

object AsLibs {

    // default support
    const val adxCoreKtx = "androidx.core:core-ktx:${Versions.adxCoreKtx}"
    const val adxAppcompat = "androidx.appcompat:appcompat:${Versions.adxAppcompat}"
    const val adxAnnotation = "androidx.annotation:annotation:${Versions.adxAnnotation}"
    const val adxConstraintlayout =
        "androidx.constraintlayout:constraintlayout:${Versions.adxConstraintlayout}"
    const val adxRecyclerView = "androidx.recyclerview:recyclerview:${Versions.adxRecyclerView}"
    const val adxViewPage = "androidx.viewpager:viewpager:${Versions.adxViewPage}"
    const val adxViewPage2 = "androidx.viewpager2:viewpager2:${Versions.adxViewPage2}"
    const val googleMaterial = "com.google.android.material:material:${Versions.googleMaterial}"
    const val adxActivity = "androidx.activity:activity:${Versions.adxActivity}"
    const val adxFragmentKtx = "androidx.fragment:fragment-ktx:${Versions.adxFragmentKtx}"
    const val adxRoom = "androidx.room:room-runtime:${Versions.room_version}"
    const val adxRoomCompiler = "androidx.room:room-compiler:${Versions.room_version}"

    // base
    const val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    const val BaseRecyclerView =
        "com.github.CymChad:BaseRecyclerViewAdapterHelper:${Versions.BaseRecyclerView}"
    const val logger = "com.orhanobut:logger:${Versions.logger}"
    const val utils = "com.blankj:utilcodex:${Versions.utils}"
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val debugDB = "com.amitshekhar.android:debug-db:${Versions.debug_db}"
    const val leakcanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakcanary}"

    // 协程
    const val kotlinCoroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
    const val kotlinCoroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"

    // 路由
    const val arouterApi = "com.alibaba:arouter-api:${Versions.arouterApi}"
    const val arouterCompiler = "com.alibaba:arouter-compiler:${Versions.arouterCompiler}"
    const val arouterRegister = "com.alibaba:arouter-register:${Versions.arouterRegister}"

    // network
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val retrofitConverters =
        "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
}