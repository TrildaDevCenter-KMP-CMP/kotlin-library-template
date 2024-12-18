rootProject.name = "kotlin-library-template"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

include(":core")
include(":extensions:example")

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
