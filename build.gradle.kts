import org.gradle.api.tasks.Delete

val composeVersion by extra { "1.4.8" }

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
    kotlin("jvm") version "1.8.22"
    //id("org.jetbrains.kotlin.android") version "1.7.21" apply false
}
