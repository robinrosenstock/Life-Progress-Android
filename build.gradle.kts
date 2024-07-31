
val composeVersion by extra { "1.5.14" }

plugins {
    id("com.android.application") version "8.5.1" apply false
    id("com.android.library") version "8.5.1" apply false
    id("com.google.dagger.hilt.android") version "2.51.1" apply false
     kotlin("jvm") version "1.9.24"
    id("com.google.devtools.ksp") version "1.9.24-1.0.20" apply false
}
