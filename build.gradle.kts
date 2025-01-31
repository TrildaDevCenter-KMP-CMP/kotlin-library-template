import com.adarshr.gradle.testlogger.theme.ThemeType.MOCHA_PARALLEL
import io.gitlab.arturbosch.detekt.Detekt

plugins {
    alias(libs.plugins.mavenPublishPlugin)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.testLogger)

    alias(libs.plugins.versionsPlugin)
    alias(libs.plugins.versionsFilterPlugin)
    alias(libs.plugins.versionCatalogUpdate)

    alias(libs.plugins.detekt)
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

tasks {
    // detektAll is a task that runs detekt on all src sets
    val detektAll by registering {
        allprojects {
            this@registering.dependsOn(tasks.withType<Detekt>())
        }
    }
    build {
        dependsOn(detektAll)
        finalizedBy(koverXmlReport, koverHtmlReport)
    }
}

allprojects {
    apply(plugin = rootProject.libs.plugins.kotlinMultiplatform.get().pluginId)
    kotlin {
        explicitApi()
        jvm()
        js {
            browser()
            nodejs()
        }
    }

    apply(plugin = rootProject.libs.plugins.mavenPublishPlugin.get().pluginId)
    mavenPublishing {
        val artifactId = if (project.name == rootProject.name) project.name else "${rootProject.name}-${project.name}"
        coordinates(artifactId = artifactId)
        pom {
            name.set(artifactId)
        }
    }

    apply(plugin = rootProject.libs.plugins.detekt.get().pluginId)
    detekt {
        toolVersion = rootProject.libs.versions.detekt.get()
        autoCorrect = true
        config.setFrom(file("$rootDir/config/detekt/detekt.yml"))
        buildUponDefaultConfig = true
        // ignoreFailures = true
    }
    dependencies {
        detektPlugins(rootProject.libs.detekt.formatting)
    }

    apply(plugin = rootProject.libs.plugins.testLogger.get().pluginId)
    testlogger {
        theme = MOCHA_PARALLEL
        showFullStackTraces = false
        slowThreshold = 1_000
    }
}
