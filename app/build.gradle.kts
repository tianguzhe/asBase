plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(29)
    buildToolsVersion = "29.0.3"

    defaultConfig {
        applicationId = "com.yikwing.myapplication"
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        targetCompatibility = JavaVersion.VERSION_1_8
        sourceCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    sourceSets {
        getByName("main") {
            res.srcDirs(
                "src/main/res",
                "src/main/res-ad",
                "src/main/res-player"
            )
        }
    }
}

dependencies {
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))
    implementation(project(mapOf("path" to ":baselibrary")))

    debugImplementation(project(mapOf("path" to ":library")))
    releaseImplementation(project(mapOf("path" to ":library-no-op")))

    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")
    implementation("androidx.core:core-ktx:1.2.0")
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("androidx.recyclerview:recyclerview:1.1.0")
    implementation("androidx.viewpager2:viewpager2:1.0.0")
    implementation("androidx.activity:activity:1.2.0-alpha03")
    implementation("androidx.fragment:fragment-ktx:1.3.0-alpha03")

    implementation(AsLibs.BaseRecyclerView)
    implementation(AsLibs.logger)
    implementation(AsLibs.okhttp)
    implementation(AsLibs.retrofit)
    implementation(AsLibs.retrofitConverters)

    implementation(AsLibs.arouterApi)
    kapt(AsLibs.arouterCompiler)

}

kapt {
    arguments {
        arg("AROUTER_MODULE_NAME", project.name)
        arg("AROUTER_GENERATE_DOC", "enable")
    }
    useBuildCache = true
    javacOptions {
        option("-Xmaxerrs", 500)
    }
}


afterEvaluate {
    tasks["build"].finalizedBy("buildR")
}

task("buildR") {
    doLast {
        exec {
            executable("./myScript.sh")
        }
    }
}