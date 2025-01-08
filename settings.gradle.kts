rootProject.name = "kotlin-library-template"
// enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

include(":core")
include(":extensions:example")

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.9.0"
}
