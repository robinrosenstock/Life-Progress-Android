
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    kotlin("plugin.serialization") version "1.9.0"
    id("com.google.devtools.ksp")
    alias(libs.plugins.compose.compiler)
}

android {
    compileSdk = 34

    defaultConfig {
        applicationId = "com.bartozo.lifeprogress"
        minSdk = 26
        targetSdk = 35
        versionCode = 13
        versionName = "1.1.2"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            //minifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    kotlin {
        jvmToolchain(17)
    }

    buildFeatures {
        compose = true
    }

    packagingOptions {
        resources {
            excludes += listOf("META-INF/AL2.0","META-INF/LGPL2.1","META-INF/DEPENDENCIES")
        }
    }
    namespace = "com.bartozo.lifeprogress"
}

dependencies {

    // Kotlin
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.coroutines.play.services)

    // Tests
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Compose
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.activity.compose)
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(libs.androidx.constraintlayout.compose)

    // Material design
    implementation(libs.androidx.material3)
    implementation(libs.material)
    implementation(libs.androidx.material.icons.extended)

    // Compose Material Dialogs
    implementation(libs.datetime)

    // DataStore
    implementation(libs.androidx.datastore.preferences)

    // Dependency Injection - Hilt
    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.hilt.work)
    ksp(libs.dagger.compiler)
    ksp(libs.hilt.compiler)

    // Accompanist
    implementation(libs.accompanist.systemuicontroller)

    // Glance
    implementation(libs.androidx.glance.appwidget)

    // WorkManager
    implementation(libs.androidx.work.runtime.ktx)

    // Splash screen
    implementation(libs.androidx.core.splashscreen)

    // In-app updates
    implementation(libs.app.update)
    implementation(libs.app.update.ktx)
    // TODO - Check why this dependency didn"t work
    // implementation "com.google.android.play:app-update-ktx:2.0.0"
}
