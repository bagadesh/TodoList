import com.baga.todolist.Libs

plugins {
    id("java-library")
    id("kotlin")
}

java {
    sourceCompatibility = Libs.Versions.JavaVersion
    targetCompatibility = Libs.Versions.JavaVersion
}