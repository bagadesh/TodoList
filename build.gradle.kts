
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
    }
}

tasks.register("clean",Delete::class) {
    delete(rootProject.buildDir)
}