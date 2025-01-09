# Kotlin Library Template [![CI](https://github.com/christian-draeger/kotlin-library-template/actions/workflows/build.yml/badge.svg)](https://github.com/christian-draeger/kotlin-library-template/actions/workflows/build.yml) ![Maven Central Version](https://img.shields.io/maven-central/v/codes.draeger/kotlin-library-template-example?logo=sonatype&label=Release)

A **universal Kotlin library template** designed to kickstart your Kotlin library projects with ease. This template provides a robust and scalable foundation for library development, with built-in automation tools to guide you from initial setup to publishing your library effortlessly.

## 🚀 Features

- **Quick Start:** No complex setup required. Simply fork this template, adjust the settings, and start coding.
- **Modular Structure:** Designed from the ground up to support splitting your library into multiple smaller libraries, enabling more granular access and flexibility for users of your project.
- **Powered by Kotlin Multiplatform:** Offers full flexibility in choosing your target platforms
- **Automated Publishing:** Fully configured Gradle setup for publishing to Maven Central or other package repositories.
- **Best Practices Included:**
    - [x] [Explicit API mode](https://kotlinlang.org/docs/whatsnew14.html#explicit-api-mode-for-library-authors) to enforce visibility to be specifically declared.
    - [x] Automatic versioning following [Semantic Versioning](https://semver.org/) principles.
    - [x] [Gradle version catalog](https://docs.gradle.org/current/userguide/version_catalogs.html) for easy and clean cross module dependency management.
    - [ ] [Gradle convention plugins](https://docs.gradle.org/current/samples/sample_convention_plugins.html) for consistent and reusable project configuration.
    - [x] Automatic dependency version checks and updates via [Gradle Versions Plugin](https://github.com/littlerobots/version-catalog-update-plugin).
    - [ ] static code analysis with [detekt](https://detekt.dev/) and [ktlint](https://ktlint.github.io/).
    - [ ] [OSS Review Toolkit](https://oss-review-toolkit.org/ort/docs/intro) integration for automated license compliance checks.
    - [ ] Testing setup and coverage reporting out of the box.
- **CI/CD Ready:** Preconfigured GitHub Actions workflows for seamless builds and releases.

---

## 📦 Benefits of the Automated Publisher

This template comes with a powerful **automated publishing system**:

1. **Secure Configuration:**
    - Handles sensitive data such as access tokens securely through environment variables.
    - Built-in support for CI/CD workflows ensures safe and consistent deployments.

2. **Automatic Versioning:**
    - Semantic Versioning is automatically managed based on tags or commit messages.
    - No manual updates required in your `build.gradle.kts`.

---

## 🛠️ Installation and Usage

1. **Use the Template:**
    - Fork the repository or use it directly as a GitHub Template.
    - Customize `settings.gradle.kts` and `build.gradle.kts` to suit your project.

2. **Adjust Modules:**
    - Modify the `core` and `example` modules, or add new ones to expand functionality.

3. **Automated Releases:**
    - Use GitHub Actions for automated CI/CD workflows.
      - The GitHub action requires the following secrets to be set in your [project settings](settings/secrets/actions) to be able to publish to Maven Central:
        - `MAVEN_CENTRAL_USERNAME`
        - `MAVEN_CENTRAL_PASSWORD`
        - `SIGNING_IN_MEMORY_KEY`
        - `SIGNING_IN_MEMORY_KEY_ID`
        - `SIGNING_IN_MEMORY_KEY_PASSWORD`
      - You can find more information about how to get the required maven central credentials [here](https://medium.com/@iRYO400/how-to-upload-your-android-library-to-maven-central-central-portal-in-2024-af7348742247) or [here](https://medium.com/@efthymiou.dimitrios1/how-to-publish-your-library-to-maven-central-3923139967e1) or in the [official documentation](https://central.sonatype.org/register/central-portal/).
    - Publishing To Maven Local:
      - ```bash
        ./gradlew publishToMavenLocal
        ```

---

## 🤖 Preconfigured CI/CD Workflows

This template includes ready-to-use GitHub Actions workflows for:
- **Build & Test:** Ensures your library is reliable and bug-free.
- **Release:** Automatically publishes new versions when a release tag is created.
- **Linting:** Keeps your code clean and adherent to Kotlin standards.

---

## ⚡️ Troubleshooting
### How to get the signing key
Please change the `<key id>` placeholder in the following command to your signing key id.
```bash
gpg --export-secret-keys --armor <key id> | grep -v '\-\-' | grep -v '^=.' | tr -d '\n'
```

---

## 📄 License

This repository is licensed under the [MIT License](LICENSE).

---

With this template, you can focus on writing great code while the boilerplate tasks are taken care of. Happy coding! 🎉
