import com.baga.todolist.Libs

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
    namespace = "com.baga.data"
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
    compileSdk = Libs.Versions.compileSDKVersion
    defaultConfig {
        minSdk = 21
        version = 1
        consumerProguardFile("consumer-rules.pro")
    }
    buildTypes {
        debug {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = Libs.Versions.JavaVersion
        targetCompatibility = Libs.Versions.JavaVersion
    }
    kotlinOptions {
        jvmTarget = Libs.Versions.jvmTarget
    }
}

//sqldelight {
//    database("MyDatabase") {
//        packageName = "com.baga.data.db"
//    }
//}