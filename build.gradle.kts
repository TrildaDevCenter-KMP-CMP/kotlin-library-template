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
    apply(plugin = "com.vanniktech.maven.publish")

    kotlin {
        jvmToolchain(22)
    }

    mavenPublishing {
        coordinates("draeger.codes", rootProject.name, "0.1.0-SNAPSHOT")
        publishToMavenCentral(SonatypeHost.S01, automaticRelease = false)
        signAllPublications()

        val githubRepo = "christian-draeger/kotlin-library-template"

        pom {
            name.set("Kotlin Library Template")
            description.set("A template project for creating new Kotlin libraries.")
            inceptionYear.set("2020")
            url.set("https://github.com/$githubRepo/")
            licenses {
                license {
                    name.set("The Apache License, Version 2.0")
                    url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
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