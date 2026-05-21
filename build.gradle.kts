plugins {
    kotlin("multiplatform") version "1.9.22"
    id("org.jetbrains.compose") version "1.6.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
    jvm {
        withJava() // Залишаємо підтримку твоїх Java-файлів з першої лаби
        jvmToolchain(17)
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.runtime)
                implementation("org.jetbrains.androidx.navigation:navigation-compose:2.7.0-alpha07")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.1")
                implementation("co.touchlab:kermit:2.0.2")
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }
    }
}