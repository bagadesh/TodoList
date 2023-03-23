import com.baga.todolist.Libs

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
//    repositories {
//        google()
//        mavenCentral()
//        maven {
//            setUrl("https://maven.google.com/")
//        }
//    }
    compileSdk = Libs.Versions.compileSDKVersion
    namespace = "com.baga.todolist"

    defaultConfig {
        applicationId = "com.baga.todolist"
        minSdk = Libs.Versions.minSdk
        targetSdk = 31
//        targetSdkPreview = "S"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
          //  proguardFile(getDefaultProguardFile("proguard-android-optimize.txt"))
        }
    }
    compileOptions {
        sourceCompatibility = Libs.Versions.JavaVersion
        targetCompatibility = Libs.Versions.JavaVersion
    }
    kotlinOptions {
        jvmTarget = Libs.Versions.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Libs.Compose.composeCompilerVersion
    }
    packagingOptions {
        resources.excludes.addAll(
            listOf(
                "META-INF/lib_release.kotlin_module",
                "META-INF/AL2.0",
                "META-INF/LGPL2.1",
            )
        )
    }
}


dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":features:baseUi"))
    implementation(project(":features:presentation"))
    implementation(project(":features:projects"))
    implementation(project(":features:tasks"))

    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("com.google.android.material:material:1.4.0")

    implementation("androidx.core:core-google-shortcuts:1.0.0")
    implementation("androidx.core:core-splashscreen:1.0.0-alpha01")

    implementation(Libs.Compose.UI)
    implementation(Libs.Compose.Material)
    implementation(Libs.Compose.Tooling)
    implementation(Libs.Compose.Activity)

    implementation(Libs.Paging.Compose)
    implementation(Libs.Paging.Runtime)

//    implementation Libs.LifeCycle.ViewModel
    implementation(Libs.LifeCycle.Runtime)
    implementation(Libs.LifeCycle.Compose)

    implementation(Libs.Hilt.Compose)
    implementation(Libs.Hilt.Android)
    kapt(Libs.Hilt.Compiler)

    implementation(Libs.Core.AndroidKtx)

//    implementation Libs.Coroutines.Android
//    implementation Libs.Coroutines.Core

    implementation(Libs.Accompanist.FlexBox)
}