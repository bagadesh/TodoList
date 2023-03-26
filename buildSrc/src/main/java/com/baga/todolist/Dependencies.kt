package com.baga.todolist

import java.awt.SplashScreen

object Libs {

    object Versions {
        val JavaVersion = org.gradle.api.JavaVersion.VERSION_17
        val jvmTarget = "17"
        val compileSDKVersion = 33
        val minSdk = 26
    }

    object Android {
        private const val gradlePluginVersion = "8.1.0-alpha09"
        const val AGP = "com.android.tools.build:gradle:$gradlePluginVersion"
    }
    object Kotlin {
        private const val kotlin_compiler_version = "1.8.10"
        const val GradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_compiler_version"
    }
    object Compose {
        const val composeCompilerVersion = "1.4.4"
        const val compose_version = "1.4.0"
        private const val activity_compose = "1.3.0-rc01"
        const val UI = "androidx.compose.ui:ui:$compose_version"
        const val Material = "androidx.compose.material:material:$compose_version"
        const val Tooling = "androidx.compose.ui:ui-tooling:$compose_version"
        const val Activity = "androidx.activity:activity-compose:$activity_compose"
        const val UnitTest = "androidx.compose.ui:ui-test-junit4:$compose_version"
        const val Navigation = "androidx.navigation:navigation-compose:2.5.1"
    }

    object Room {
        private const val room_version = "2.5.0"
        const val Runtime = "androidx.room:room-runtime:$room_version"
        const val Compiler = "androidx.room:room-compiler:$room_version"
        const val Ktx = "androidx.room:room-ktx:$room_version"
    }

    object Paging {
        private const val paging_version = "3.0.0"
        private const val compose_version = "1.0.0-alpha10"
        const val Compose = "androidx.paging:paging-compose:$compose_version"
        const val Runtime = "androidx.paging:paging-runtime:$paging_version"

        const val Common = "androidx.paging:paging-common-ktx:$paging_version"
    }

    object LifeCycle {
        private const val ktx_version = "2.3.1"
        private const val compose_viewModel_version = "1.0.0-alpha07"
        const val ViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$ktx_version"
        const val Runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$ktx_version"
        const val LiveData = "androidx.lifecycle:lifecycle-livedata-ktx:$ktx_version"
        const val Compose = "androidx.lifecycle:lifecycle-viewmodel-compose:$compose_viewModel_version"

    }

    object Core {
        private const val ktx_version = "1.5.0"
        private const val splash_screen_version = "1.0.0-alpha01"
        const val AndroidKtx = "androidx.core:core-ktx:$ktx_version"
        const val SplashScreen = "androidx.core:core-slashscreen:$splash_screen_version"
    }

    object AndroidX {
        private const val appCompactVersion = "1.3.0"
        const val AppCompact = "androidx.appcompat:appcompat:$appCompactVersion"
    }

    object Material {
        private const val version = "1.3.0"
        const val Material = "com.google.android.material:material:$version"
    }

    object Hilt {
        private const val hilt_version = "2.45"
        private const val hiltComposeVerion = "1.0.0"
        const val Android = "com.google.dagger:hilt-android:$hilt_version"
        const val Compiler = "com.google.dagger:hilt-android-compiler:$hilt_version"
        const val Core = "com.google.dagger:hilt-core:$hilt_version"
        const val Plugin = "com.google.dagger:hilt-android-gradle-plugin:$hilt_version"
        const val Compose = "androidx.hilt:hilt-navigation-compose:$hiltComposeVerion"
    }

    object Coroutines {
        private const val coroutine_version = "1.5.0"
        private const val version = "1.4.1"
        const val Android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutine_version"
        const val Core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutine_version"
    }

    object Accompanist {
        private const val version = "0.12.0"
        const val FlexBox = "com.google.accompanist:accompanist-flowlayout:$version"
    }
    object DataBase {
        object SqlDelight {
            private const val sql_delight_version = "1.5.0"
            const val Plugin = "com.squareup.sqldelight:gradle-plugin:$sql_delight_version"
            const val Runtime = "com.squareup.sqldelight:runtime:$sql_delight_version" //CommonSet
            const val AndroidDriver = "com.squareup.sqldelight:android-driver:$sql_delight_version" // Android Specific Module
        }
    }

    object ThirdParty {
        const val DatePicker = "com.squaredem:composecalendar:1.0.0"
        const val FuzzySearch = "me.xdrop:fuzzywuzzy:1.4.0"
    }
}