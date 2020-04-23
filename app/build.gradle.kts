plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(Versions.compileSdkVersion)
    buildToolsVersion = Versions.buildToolsVersion

    defaultConfig {
        applicationId = "com.yikwing.myapplication"
        minSdkVersion(Versions.minSdkVersion)
        targetSdkVersion(Versions.targetSdkVersion)
        versionCode = Versions.versionCode
        versionName = Versions.versionName

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

    debugImplementation(project(mapOf("path" to ":networkLibrary")))
    releaseImplementation(project(mapOf("path" to ":networkLibrary-no-op")))

    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")
    implementation(AsLibs.adxCoreKtx)
    implementation(AsLibs.adxAppcompat)
    implementation(AsLibs.adxConstraintlayout)
    implementation(AsLibs.adxRecyclerView)
    implementation(AsLibs.adxActivity)
    implementation(AsLibs.adxFragmentKtx)

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