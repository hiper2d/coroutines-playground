plugins {
    kotlin("jvm") version "1.7.10"
}

val javafxControlsVersion: String by project
val kotlinCoroutinesVersion: String by project

repositories {
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-javafx:$kotlinCoroutinesVersion")
    implementation("org.openjfx:javafx-controls:$javafxControlsVersion")
    implementation("org.openjfx:javafx-graphics:$javafxControlsVersion")
    implementation("org.openjfx:javafx-controls:$javafxControlsVersion")
}