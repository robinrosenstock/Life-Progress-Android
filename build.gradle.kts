
plugins {
    id("com.android.application") version "8.5.1" apply false
    id("com.android.library") version "8.5.1" apply false
    id("com.google.dagger.hilt.android") version "2.51.1" apply false
    kotlin("jvm") version "2.0.0"
    id("com.google.devtools.ksp") version "2.0.0-1.0.24" apply false
    alias(libs.plugins.compose.compiler) apply false
}
