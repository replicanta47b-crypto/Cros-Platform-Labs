plugins {
    kotlin("jvm") version "1.9.22"
    id("org.jetbrains.compose") version "1.6.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    testImplementation(kotlin("test"))
    // Бібліотеки для 2-ї лабораторної
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.1")
    implementation("co.touchlab:kermit:2.0.2")

    implementation(compose.desktop.currentOs)
    implementation("org.jetbrains.androidx.navigation:navigation-compose:2.7.0-alpha07")
}

kotlin {
    jvmToolchain(17)
}

tasks.test {
    useJUnitPlatform()
}