# kotlin-library-template [![CI](https://github.com/christian-draeger/kotlin-library-template/actions/workflows/build.yml/badge.svg)](https://github.com/christian-draeger/kotlin-library-template/actions/workflows/build.yml)
A template project to jumpstart the creation and publishing of new Kotlin libraries.

## Publishing
The template project uses [vanniktech/maven-publish-plugin](https://github.com/vanniktech/gradle-maven-publish-plugin) for publishing to Maven Central.
To make the github action work, you need to add the following environment variables to your github repository:
- `ORG_GRADLE_PROJECT_signingInMemoryKey`
- `ORG_GRADLE_PROJECT_signingInMemoryKeyId`
- `ORG_GRADLE_PROJECT_signingInMemoryKeyPassword`
- `ORG_GRADLE_PROJECT_mavenCentralUsername`
- `ORG_GRADLE_PROJECT_mavenCentralPassword`
