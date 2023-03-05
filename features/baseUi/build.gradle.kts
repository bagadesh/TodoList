import com.baga.todolist.Libs

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.bagadesh.baseui"
    compileSdk = Libs.Versions.compileSDKVersion

    defaultConfig {
        minSdk = Libs.Versions.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
}

dependencies {
    implementation(project(mapOf("path" to ":domain")))

    implementation(Libs.Compose.UI)
    implementation(Libs.Compose.Material)
    implementation(Libs.Compose.Tooling)
}