plugins {
    id("com.android.library")
}

android {
    compileSdkVersion(Versions.compileSdkVersion)

    defaultConfig {
        minSdkVersion(Versions.minSdkVersion)
    }
}

dependencies {
    implementation(AsLibs.kotlinStdlib)
    implementation(AsLibs.okhttp)
}