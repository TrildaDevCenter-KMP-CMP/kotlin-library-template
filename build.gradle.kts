import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.kotlinPluginJvm)
    alias(libs.plugins.mavenPublishPlugin)
}

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    kotlin {
        jvmToolchain(22)
    }

    apply(plugin = "com.vanniktech.maven.publish")

    kotlin {
        jvmToolchain(22)
    }

    mavenPublishing {
        publishToMavenCentral(SonatypeHost.S01, automaticRelease = false)
        signAllPublications()

        val githubRepo = "christian-draeger/kotlin-library-template"

        pom {
            name.set("Kotlin Library Template")
            description.set("A template project for creating new Kotlin libraries.")
            inceptionYear.set("2024")
            url.set("https://github.com/$githubRepo/")
            licenses {
                license {
                    name.set("MIT License")
                    url.set("https://opensource.org/licenses/MIT")
                }
            }
            developers {
                developer {
                    id.set("christian-draeger")
                    name.set("Christian Dräger")
                    url.set("https://github.com/christian-draeger/")
                }
            }
            scm {
                url.set("https://github.com/$githubRepo/")
                connection.set("scm:git:git://$githubRepo.git")
                developerConnection.set("scm:git:ssh://git@github.com/$githubRepo.git")
            }
        }
    }

    dependencies {
        testImplementation(kotlin("test"))
    }

    tasks.test {
        useJUnitPlatform()
    }
}