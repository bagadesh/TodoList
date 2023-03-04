plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.bagadesh.baseui"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = com.baga.todolist.Libs.Versions.JavaVersion
        targetCompatibility = com.baga.todolist.Libs.Versions.JavaVersion
    }
    kotlinOptions {
        jvmTarget = com.baga.todolist.Libs.Versions.jvmTarget
    }
}

dependencies {
    implementation(com.baga.todolist.Libs.Compose.UI)
    implementation(com.baga.todolist.Libs.Compose.Material)
    implementation(com.baga.todolist.Libs.Compose.Tooling)
}