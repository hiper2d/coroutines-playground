plugins {
    kotlin("jvm") version "1.7.10"
    id("org.openjfx.javafxplugin") version "0.0.10"
}

val javafxControlsVersion: String by project
val kotlinCoroutinesVersion: String by project

repositories {
    mavenCentral()
}

javafx {
    modules("javafx.controls")
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-javafx:$kotlinCoroutinesVersion")
}