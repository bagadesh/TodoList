package com.baga.todolist

object Libs {
    object Kotlin {
        const val kotlin_compiler_version = "1.5.10"
        const val GradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_compiler_version"
    }
    object Compose {
        const val compose_version = "1.0.0-beta09"
        private const val compose_version_old = "1.0.0-beta09"
        private const val activity_compose = "1.3.0-beta02"
        const val UI = "androidx.compose.ui:ui:$compose_version"
        const val Material = "androidx.compose.material:material:$compose_version"
        const val Tooling = "androidx.compose.ui:ui-tooling:$compose_version"
        const val Activity = "androidx.activity:activity-compose:$activity_compose"
        const val UnitTest = "androidx.compose.ui:ui-test-junit4:$compose_version"
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
        const val AndroidKtx = "androidx.core:core-ktx:$ktx_version"
    }

    object AndroidX {
        const val appCompactVersion = "1.3.0"
        const val AppCompact = "androidx.appcompat:appcompat:$appCompactVersion"
    }

    object Material {
        const val version = "1.3.0"
        const val Material = "com.google.android.material:material:$version"
    }

    object Hilt {
        private const val hilt_version = "2.37"
        const val Android = "com.google.dagger:hilt-android:$hilt_version"
        const val Compiler = "com.google.dagger:hilt-android-compiler:$hilt_version"
        const val Plugin = "com.google.dagger:hilt-android-gradle-plugin:$hilt_version"
    }

    object Coroutines {
        private const val coroutine_version = "1.5.0"
        private const val version = "1.4.1"
        const val Android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutine_version"
        const val Core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutine_version"
    }
}