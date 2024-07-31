import org.gradle.api.tasks.Delete

val composeVersion by extra { "1.4.8" }

plugins {
    id("com.android.application") version "8.5.1" apply false
    id("com.android.library") version "8.5.1" apply false
    id("com.google.dagger.hilt.android") version "2.43.2" apply false
    kotlin("jvm") version "1.8.22"
}
