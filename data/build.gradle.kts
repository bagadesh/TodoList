import com.baga.todolist.Libs

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

dependencies {
    implementation(project(":domain"))
    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("com.google.android.material:material:1.3.0")
    implementation(Libs.Paging.Compose)
    implementation(Libs.Paging.Runtime)
    implementation(Libs.Hilt.Android)
    kapt(Libs.Hilt.Compiler)
//    implementation(Libs.DataBase.SqlDelight.Runtime)
//    implementation(Libs.DataBase.SqlDelight.AndroidDriver)

    implementation(Libs.Room.Runtime)
    kapt(Libs.Room.Compiler)
    implementation(Libs.Room.Ktx)
}

android {
    compileSdk = 30
    buildToolsVersion = "30.0.3"
    defaultConfig {
        minSdk = 21
        targetSdk = 30
        version = 1

        consumerProguardFile("consumer-rules.pro")
    }
    buildTypes {
        debug {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

//sqldelight {
//    database("MyDatabase") {
//        packageName = "com.baga.data.db"
//    }
//}