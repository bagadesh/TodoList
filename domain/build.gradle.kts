import com.baga.todolist.Libs

plugins {
    id("java-library")
    id("kotlin")
}

java {
    sourceCompatibility = Libs.Versions.JavaVersion
    targetCompatibility = Libs.Versions.JavaVersion
}

dependencies {
    implementation(Libs.Coroutines.Core)
    implementation(Libs.Hilt.Core)
}