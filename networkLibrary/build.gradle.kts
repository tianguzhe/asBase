plugins {
    id("com.android.library")
}

android {
    compileSdkVersion(Versions.compileSdkVersion)

    defaultConfig {
        minSdkVersion(Versions.minSdkVersion)
        consumerProguardFiles("proguard-rules.pro")
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")
    implementation(AsLibs.adxAnnotation)
    implementation(AsLibs.adxCoreKtx)
    implementation(AsLibs.adxViewPage)
    implementation(AsLibs.adxAppcompat)
    implementation(AsLibs.adxActivity)
    implementation(AsLibs.googleMaterial)

    implementation(AsLibs.okhttp)
    implementation(AsLibs.gson)
    implementation("nl.qbusict:cupboard:2.2.0")
}