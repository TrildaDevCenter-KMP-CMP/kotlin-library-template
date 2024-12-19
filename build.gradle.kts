import com.adarshr.gradle.testlogger.theme.ThemeType.MOCHA_PARALLEL

group = "codes.draeger"
version = "0.0.1-SNAPSHOT"

plugins {
    alias(libs.plugins.mavenPublishPlugin)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.testLogger)
}

allprojects {
    apply(plugin = "org.jetbrains.kotlin.multiplatform")
    apply(plugin = "com.vanniktech.maven.publish")
    apply(plugin = "com.adarshr.test-logger")

    kotlin {
        jvm()
    }

    testlogger {
        theme = MOCHA_PARALLEL
        showFullStackTraces = false
        slowThreshold = 1_000
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
