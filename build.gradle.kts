buildscript {
    repositories {
        google()
    }
    dependencies {
        val navVersion = "2.5.2"
        //noinspection GradleDependency
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$navVersion")
    }
}

plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id("androidx.navigation.safeargs") version "2.5.2" apply false

}