
buildscript {
    repositories {
        google()
        mavenCentral()
        maven {
            setUrl("https://maven.google.com/")
        }
    }
    dependencies {
        classpath(com.baga.todolist.Libs.Android.AGP)
        classpath(com.baga.todolist.Libs.Kotlin.GradlePlugin)
        classpath(com.baga.todolist.Libs.Hilt.Plugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.10")
    }
}

tasks.register("clean",Delete::class) {
    delete(rootProject.buildDir)
}