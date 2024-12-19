import com.adarshr.gradle.testlogger.theme.ThemeType.MOCHA_PARALLEL

group = "codes.draeger"
version = "0.0.1-SNAPSHOT"

plugins {
    alias(libs.plugins.mavenPublishPlugin)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.testLogger)
}

val signingInMemoryKeyId: String? by project
val signingInMemoryKey: String? by project
val signingInMemoryKeyPassword: String? by project

val signingEnabled: Provider<Boolean> = provider {
    signingInMemoryKeyId != null && signingInMemoryKey != null && signingInMemoryKeyPassword != null
}

allprojects {
    apply(plugin = "org.jetbrains.kotlin.multiplatform")
    apply(plugin = "com.vanniktech.maven.publish")
    apply(plugin = "com.adarshr.test-logger")

    kotlin {
        jvm()
    }

    mavenPublishing {
        if (signingEnabled.get()) {
            signAllPublications()
        }
        val artifactId = if (project.name == rootProject.name) project.name else "${rootProject.name}-${project.name}"
        coordinates(artifactId = artifactId)
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
