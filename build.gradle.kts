import com.adarshr.gradle.testlogger.theme.ThemeType.MOCHA_PARALLEL

plugins {
    alias(libs.plugins.mavenPublishPlugin)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.testLogger)

    alias(libs.plugins.versionsPlugin)
    alias(libs.plugins.versionsFilterPlugin)
    alias(libs.plugins.versionCatalogUpdate)
}

// aggregate dependents to an all-in-one library
kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.core)
            api(projects.example)
        }
    }
}

allprojects {
    apply(plugin = "org.jetbrains.kotlin.multiplatform")
    apply(plugin = "com.vanniktech.maven.publish")
    apply(plugin = "com.adarshr.test-logger")

    kotlin {
        explicitApi()
        jvm()
        js {
            browser()
            nodejs()
        }
    }

    mavenPublishing {
        val artifactId = if (project.name == rootProject.name) project.name else "${rootProject.name}-${project.name}"
        coordinates(artifactId = artifactId)
        pom {
            name.set(artifactId)
        }
    }

    testlogger {
        theme = MOCHA_PARALLEL
        showFullStackTraces = false
        slowThreshold = 1_000
    }
}
