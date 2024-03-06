// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val hiltVersion = "2.48.1"
    val roomVersion = "2.6.1"
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion")
    }
    extra.set("hiltVersion", hiltVersion)
    extra.set("roomVersion", roomVersion)
}
plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
    id("com.google.devtools.ksp") version "1.9.10-1.0.13" apply false
}