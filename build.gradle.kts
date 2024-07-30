import org.gradle.api.tasks.Delete

val composeVersion by extra { "1.4.0-alpha02" }

buildscript {
    extra.apply {
        set("kotlin_version", "1.8.0")
        set("nav_version", "2.5.1")
    }

    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.43.2")
    }
}

plugins {
    id("com.android.application") version "8.5.1" apply false
    id("com.android.library") version "8.5.1" apply false
    id("org.jetbrains.kotlin.android") version "1.7.21" apply false
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
