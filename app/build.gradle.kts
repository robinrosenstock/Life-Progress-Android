
val composeVersion: String by rootProject.extra

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    kotlin("plugin.serialization") version "1.9.0"
    id("com.google.devtools.ksp")
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
    composeOptions {
        kotlinCompilerExtensionVersion = composeVersion
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
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.8.1")

    // Tests
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    // Compose
    implementation("androidx.navigation:navigation-compose:2.7.7")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.activity:activity-compose:1.9.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$composeVersion")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")

    // Material design
    implementation("androidx.compose.material3:material3:1.1.0-alpha07")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.compose.material:material-icons-extended:1.6.8")

    // Compose Material Dialogs
    implementation("io.github.vanpra.compose-material-dialogs:datetime:0.9.0")

    // DataStore
    implementation("androidx.datastore:datastore-preferences:1.1.1")

    // Dependency Injection - Hilt
    implementation("com.google.dagger:hilt-android:2.51.1")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    implementation("androidx.hilt:hilt-work:1.2.0")
    ksp("com.google.dagger:dagger-compiler:2.51.1")
    ksp("com.google.dagger:hilt-compiler:2.51.1")

    // Accompanist
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.34.0")

    // Glance
    implementation("androidx.glance:glance-appwidget:1.0.0-alpha05")

    // WorkManager
    implementation("androidx.work:work-runtime-ktx:2.8.1")

    // Splash screen
    implementation("androidx.core:core-splashscreen:1.0.1")

    // In-app updates
    implementation("com.google.android.play:app-update:2.1.0")
    implementation("com.google.android.play:app-update-ktx:2.1.0")
    // TODO - Check why this dependency didn"t work
    // implementation "com.google.android.play:app-update-ktx:2.0.0"
}
