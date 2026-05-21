plugins {
    kotlin("jvm") version "2.3.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    // Бібліотеки для 2-ї лабораторної
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.1")
    implementation("co.touchlab:kermit:2.0.2")
}

kotlin {
    jvmToolchain(25)
}

tasks.test {
    useJUnitPlatform()
}