import org.gradle.api.tasks.Delete

buildscript {
    extra.apply {
        set("kotlin_version", "1.8.0")
        set("compose_version", "1.3.0-beta01")
        set("nav_version", "2.5.1")
    }

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.43.2")
    }
}

plugins {
    id("com.android.application") version "8.5.1" apply false
    id("com.android.library") version "8.5.1" apply false
    id("org.jetbrains.kotlin.android") version "1.7.10" apply false
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
